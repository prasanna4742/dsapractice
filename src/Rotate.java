public class Rotate {
    public static void main(String[] args) {
        // rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        // rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
        rotate(new int[][]{{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}});
    }

    public static void rotate(int[][] matrix) {
        System.out.println("--------------------");
        printMatrix(matrix);
        System.out.println("---->");
        int n = matrix.length;
        int left = 0;
        int right = n-1;

        while (right -left > 0)
        {
            int top = left;
            int bottom = right;
    
            for (int i=0; i<right-left; i++){

                // save top left+1
                int tmp = matrix[top][left+i];
                // top left = bottom-1 left
                matrix[top][left+i] = matrix[bottom-i][left];
                // bottom-1 left = bottom right-1
                matrix[bottom-i][left] = matrix[bottom][right-i];
                // bottom right-1 = top+1 right
                matrix[bottom][right-i] = matrix[top+i][right];
                // top+1 right = top left+1
                matrix[top+i][right] = tmp;
            }
            left = left+1;
            right = right -1;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


}
