import java.util.HashSet;

public class RandomizedSet {

    HashSet<Integer> underlayingSet;
    public RandomizedSet() {
        underlayingSet = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        return underlayingSet.add(val);
    }
    
    public boolean remove(int val) {
        return underlayingSet.remove(val);        
    }
    
    public int getRandom() {
        int index = (int) (underlayingSet.size()*Math.random());
        Integer[] intArr = (Integer[])underlayingSet.toArray(new Integer[0]);
        return intArr[index];
        
    }    
    public static void main(String[] args) {
        
    }

}
