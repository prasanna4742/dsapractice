public class RectArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));   
        System.out.println(computeArea(-2,-2,2,2,-2,-2,2,2));   
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        // ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2

        int area = ((ax2-ax1)*(ay2-ay1))+((bx2-bx1)*(by2-by1));
        int dx1=0,dx2=0,dy1=0,dy2=0;
        if( bx2 <= ax1 || bx1 >= ax2 || by2 <= ay1 || by1 >= ay2)
        {
            return area;
        }

        dx1 = Math.max(ax1, bx1);
        dx2 = Math.min(ax2, bx2);
        dy1 = Math.max(ay1, by1);
        dy2 = Math.min(ay2, by2);

        return area - ((dx2-dx1)*(dy2-dy1));
    }

}
