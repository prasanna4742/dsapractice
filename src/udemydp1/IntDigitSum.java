package udemydp1;

public class IntDigitSum {
    public static void main(String[] args) {
        System.out.println(sum(1234));        
        System.out.println(sum(2));        
        System.out.println(sum(3001));        

        System.out.println(sum(123456));        

    }
    
    private static int sum(int i) {
        if(i<10){
            return i;
        }
        return i%10 +sum(i/10);
    }

}
