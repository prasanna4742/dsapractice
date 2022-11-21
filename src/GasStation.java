public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        
        for(int i =0; i<gas.length; i++){
            if(gas[i] == 0){
                continue;
            }

            int j =i;
            int visits=0;
            int capacity=0;
            while( visits < gas.length){
                // int next = (j+1>=gas.length)?(j+1)%gas.length:j+1;
                if(j>=gas.length){
                    j=(j)%gas.length;
                }
                capacity = capacity + gas[j];
                // System.out.println(capacity+","+cost[j]+","+gas[j]);
                capacity = capacity - cost[j];
                // System.out.println("Capacity for "+j+" to "+next+" is "+capacity);
                if(capacity < 0){
                    // System.out.println("next i now - "+(i+1));
                    break;
                }
                visits++;
                j++;
            }

            if(visits >= gas.length){
                // System.out.println(i);
                return i;
            }
            // System.out.println("Visits:"+ visits);
            // System.out.println("----------------");
        }
        return result;
    }    
}
