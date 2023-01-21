package udemydp1;

public class CheckSeq {
    public static void main(String[] args) {
        System.out.println(checkSeq(new int[]{1,2,4,7,11}));    
        System.out.println(checkSeq(new int[]{1,2,4,3,11}));    
    }

    private static boolean checkSeq(int[] arr) {
        return checkSeqRec(arr, arr.length-1);
    }

    private static boolean checkSeqRec(int[] arr, int i) {

        if( i == 0){
            return true;
        }

        return (arr[i] > arr[i-1] && checkSeqRec(arr, i-1));
    }


}
