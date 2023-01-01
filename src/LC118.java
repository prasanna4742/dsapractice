import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.event.PrintEvent;

public class LC118 {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        List<Integer> currRow, preRow = null;

        for(int i =0; i<numRows; i++){
            currRow = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j ==0 || j ==i){
                    currRow.add(1);
                }
                else{
                    currRow.add(preRow.get(j-1)+preRow.get(j));
                }
                preRow = currRow;
            }
            retList.add(currRow);
        }

        return retList;
    }

}
