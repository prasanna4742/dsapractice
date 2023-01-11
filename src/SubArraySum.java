public class SubArraySum {
    public static void main(String[] args) {
        //[-1,6,5,8,11,9,2], 11
        //6,5
        //11
        //11,9,-9
        //2,9
        //Return count of all subArrays
        System.out.println(findSubArrayPerSum(new int[]{-1,6,5,8,11,9,-9,2,9}, 11));
    }

    public static int  findSubArrayPerSum(int[] input, int targetSum){

        int size=0;
        for(int i=0; i< input.length; i++){

            int sum=0;
            for(int j=i; j<input.length; j++){
                sum += input[j];
                if(sum == targetSum){
                    size++;
                }
            }
        }
        return size;
    }
}
