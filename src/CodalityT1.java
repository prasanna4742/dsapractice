import java.util.Arrays;

public class CodalityT1 {
    public static void main(String[] args) {
        System.out.println(boardLen(new int[]{0,5,10,18,20}));
        System.out.println(boardLen(new int[]{0,4,8,10,12,14,22,40}));
        System.out.println(boardLen(new int[]{0,5,8}));
        System.out.println(boardLen(new int[]{0,1,8}));
        System.out.println(boardLen(new int[]{9,11,15,20}));
        System.out.println(boardLen(new int[]{0,16,18,30,32,34,35,42,44}));

    }


    public static int boardLen(int A[]){
        if(A.length == 1 || A.length == 2){
            return 1;
        }

        Arrays.sort(A);

        if(A.length == 3){
            return Math.min(A[1]-A[0], A[2]-A[1]);
        }

        int prevMax = Integer.MAX_VALUE;
        int start = A[0];
        int end = A[A.length-1];

        for(int i=1; i<A.length-2; i++){
            int currMax = Math.max(A[i]-start, end-A[i+1]);
            if(currMax > prevMax){
                break;
            }
            else{
                prevMax = currMax;
            }
        }
        return prevMax;
    }
}
