import java.util.ArrayList;
import java.util.List;

public class Build {
    public static void main(String[] args) {
        System.out.println(convert("ABCDEFGHIJKLMNOP",4));
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("PAYPALISHIRING",4));
        System.out.println(convert("A",1));

    }
    

    public static String convert(String s, int numRows) {

        if(numRows == 1)
            return s;
        List[] levelArr = new List[numRows];
        for( int i=0; i<numRows; i++){
            levelArr[i]=new ArrayList<Character>(); 
            //System.out.println(levelArr[i]);
        }

        int modFactor = numRows+(numRows-2);
        int currLevel = 0;
        for(int i=0; i<s.length(); i++) 
        {
            int modVal = i%modFactor;
            if(modVal < numRows)
            {
                if(modVal == 0)
                {
                    currLevel = 0;    
                }
                levelArr[currLevel].add(Character.valueOf(s.charAt(i)));
                currLevel++;
            }
            else
            {
                if(currLevel == numRows)
                {
                    currLevel--;    
                }
                currLevel--;
                levelArr[currLevel].add(Character.valueOf(s.charAt(i)));
            }
        }
        StringBuffer sBuff = new StringBuffer("");
        for(List aList : levelArr)
        {
            
            aList.forEach(sBuff::append);
        }
        return sBuff.toString();
    }
}
