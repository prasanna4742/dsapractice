import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TTLPriorityLRUCache {
    
    private final int capacity;
    private Map<Integer, String> cache;
    private Map<Integer, Long> keysAndTheirTTL;
    private Thread ttlAuditThread;
    private TTLAudit ttlAudit;
    private Deque<Integer> lruQueue;
    private PriorityQueue<CustomKey> pQ;
    private Map<Integer, CustomKey> keyToKeePriority;
    private Comparator<CustomKey> customKeyComparator = new Comparator<CustomKey>() {

        @Override
        public int compare(CustomKey k1, CustomKey k2) {
            if(k1.priority < k2.priority){
                return 1;
            }
            else if(k1.priority > k2.priority) {
                return -1;
            }
            return 0;
        }        
    };
    
    public TTLPriorityLRUCache(int capacity)
    {
        this.capacity = capacity;
        cache = new ConcurrentHashMap<Integer, String>(capacity);
        keysAndTheirTTL = new ConcurrentHashMap<Integer, Long>(capacity);
        ttlAudit = new TTLAudit();
        ttlAuditThread = new Thread(ttlAudit);
        ttlAuditThread.start();
        lruQueue = new ArrayDeque<>(capacity);
        pQ = new PriorityQueue<CustomKey>(customKeyComparator);
        keyToKeePriority = new HashMap<Integer, CustomKey>(capacity);
    }

    class CustomKey {
        private int key;
        private int priority;
        public CustomKey(int key, int priority){
            this.key = key;
            this.priority = priority;
        }
    }

    class TTLAudit implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    removeExpiredEntries();
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }            

        public void removeExpiredEntries(){
            Set<Entry<Integer, Long>> entrySet = keysAndTheirTTL.entrySet();
            List<Integer> expiredKeys = new ArrayList<Integer>();
            for( Entry<Integer, Long> currentEntry : entrySet ){
                if (currentEntry.getValue() < System.currentTimeMillis()){
                    expiredKeys.add(currentEntry.getKey());
                }
            }
            
            for(Integer key : expiredKeys) {
                cache.remove(key);
                keysAndTheirTTL.remove(key);
                lruQueue.remove(key);
            }
        }
    }

    public void printCache(){
        for(String obj : cache.values()){
            System.out.println(obj);
        }
    }

    public void put(int key, String value, int TTLinSeconds, int priority) {
        if(cache.size() == capacity)
        {
            evictFromCache(priority);
        }

        cache.put(key, value);
        keysAndTheirTTL.put(key, System.currentTimeMillis()+(TTLinSeconds*1000));
        lruQueue.addFirst(key);
        CustomKey cKey = new CustomKey(key, priority);
        pQ.add(cKey);
        keyToKeePriority.put(key, cKey);
    }

    public String get(int key) {
        if(cache.containsKey(key))
        {
            lruQueue.remove(key);
            lruQueue.addFirst(key);
        }
        return null;
    }

    private void evictFromCache(int insertionPriority) {
        //First remove TTL
        ttlAudit.removeExpiredEntries();
        
        //Second remove lower priority
        if(cache.size() == capacity){
            CustomKey firstKey = pQ.peek();
            if(insertionPriority < firstKey.priority)
            {
                pQ.remove(firstKey);
                lruQueue.remove(firstKey.key);
                cache.remove(firstKey.key);
                keysAndTheirTTL.remove(firstKey.key);    
                keyToKeePriority.remove(firstKey.key);
            }
        }        

        //Third remove LRU
        if(cache.size() == capacity){
            Integer key = lruQueue.peekLast();
            lruQueue.remove(key);
            cache.remove(key);
            keysAndTheirTTL.remove(key);
            pQ.remove(keyToKeePriority.get(key));
            keyToKeePriority.remove(key);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TTLPriorityLRUCache myCache = new TTLPriorityLRUCache(3);
        myCache .put(1, "First", 10000,1);
        myCache .put(2, "Second", 10000,2);
        myCache .put(3, "Third", 30000,3);
        // Thread.sleep(2000L);
        myCache .put(4, "four", 30000,0);

        myCache.printCache();
    }
}