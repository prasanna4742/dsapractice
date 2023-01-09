import java.util.Arrays;

public class LC945 {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));        
    }

    public static int minIncrementForUnique(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        Arrays.sort(nums);
        int[] filler = new int[200000];
        for(int n : nums){
            filler[n]++;
        }

        int jumps = 0;
        for(int i=nums[0]; i<filler.length; i++){

            if(filler[i] <= 1){
                continue;
            }

            
            int remaining = filler[i] -1;
            jumps += remaining;
            filler[i+1] = filler[i+1]+remaining;
        }
        return jumps;
    }

    //Works but timelimit exceeeded
    // public static int minIncrementForUnique(int[] nums) {
    //     int jumps=0;
    //     if(nums.length == 1){
    //         return 0;
    //     }

    //     int[] sorted = nums.clone();
    //     Arrays.sort(sorted);        

    //     int max = sorted[sorted.length-1]+1;
    //     List<Integer[]> gaps = new ArrayList<Integer[]>();
    //     Map<Integer, Integer> duplicates = new HashMap<Integer, Integer>();        

    //     for(int i=1; i<sorted.length; i++){
    //         if(sorted[i-1] == sorted[i]){
    //             duplicates.put(sorted[i], duplicates.getOrDefault(sorted[i], 0)+1);
    //             continue;
    //         }

    //         if(sorted[i]-sorted[i-1] > 1){
    //             gaps.add(new Integer[]{sorted[i-1]+1, sorted[i]-1});
    //         }
    //     }

    //     for(int i=0; i<nums.length; i++){
    //         if(duplicates.getOrDefault(nums[i], 0) <= 0){
    //             continue;
    //         }
    //         duplicates.put(nums[i], duplicates.get(nums[i])-1);
    //         boolean replaced = false;
    //         int j=0;
    //         for(; j<gaps.size(); j++){
    //             Integer[] gap = gaps.get(j);
    //             if(nums[i] <gap[0]){
    //                 jumps = jumps + (gap[0] - nums[i]);
    //                 nums[i] = gap[0];
    //                 replaced = true;
    //                 gap[0]++;
    //                 if(gap[0] > gap[1]){
    //                     gaps.remove(j);
    //                 }
    //                 break;
    //             }
    //         }
    //         if(!replaced){
    //             jumps = jumps + max - nums[i];
    //             nums[i] = max;
    //             max++;
    //         }
    //     }

    //     return jumps;
    // }    
}
