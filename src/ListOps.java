import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOps {
    public static void main(String[] args) {
        // Find Strings delta - start
        List<String> prevString = new ArrayList<String>(Arrays.asList(new String[]{"Tom","Dick","Harry"}));
        List<String> modiString = new ArrayList<String>(Arrays.asList(new String[]{"Tom","Changu","Mangu","Dick"}));
        List<String> remStrings = new ArrayList<String>();
        List<String> addStrings = new ArrayList<String>();

        prevString.stream()
                .filter(currentElement -> !modiString.contains(currentElement))
                .forEach(remStrings::add);

        modiString.stream()
                .filter(currentElement -> !prevString.contains(currentElement))
                .forEach(addStrings::add);

        prevString.removeAll(remStrings);
        prevString.addAll(addStrings);
        remStrings = null;
        addStrings = null;
        // Find Strings delta - end                    
        System.out.println(prevString);
    }
}
