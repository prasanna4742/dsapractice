import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BPPotentialProblem {
    public static void main(String[] args) {
        Map<Character, Character> sllMap = new HashMap<Character, Character>();
        List<Set<Character>> startSets = new ArrayList<Set<Character>>();
        readInput(sllMap, startSets);
        findIntersection(sllMap, startSets);
        System.out.println("Done");
    }

    private static void findIntersection(Map<Character, Character> sllMap, List<Set<Character>> startSets) {

        for(Set<Character> startSet : startSets){

            Set<Character> visitedNodes = new HashSet<Character>();
            boolean intersectionFound = false;
            for(Character c : startSet){
                intersectionFound = visit(c, visitedNodes, sllMap);
                if(intersectionFound){
                    break;
                }
            }
            if(intersectionFound){
                System.out.println("True");
            }
            else{
                System.out.println("False");
            }

        }
    }

    private static boolean visit(Character c, Set<Character> visitedNodes, Map<Character, Character> sllMap) {
        //Do two things here - check cycle within LL, then check intersection
        Set<Character> currentLLNodes = new HashSet<Character>();

        //No recusrsion so need to use Q
        Queue<Character> llNodes = new ArrayDeque<Character>();

        //Add first element to start traversal
        llNodes.offer(c); 

        while(!llNodes.isEmpty()){
            Character currNode = llNodes.poll();
            //First check cycle
            if(currentLLNodes.contains(currNode)){
                //Cycle detected
                throw new IllegalArgumentException("Cycle detected in LL starting with "+c);
            }
            currentLLNodes.add(currNode);
            //Now check for intersection
            if(visitedNodes.contains(currNode)){
                // System.out.println("True");
                return true;
            }
            visitedNodes.add(currNode);
            Character nextNode = sllMap.get(currNode);
            if(nextNode!= null){
                llNodes.offer(nextNode);
            }
        }

        return false;
    }

    private static void readInput(Map<Character, Character> map, List<Set<Character>> startSets) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String line = input.nextLine();
            if(line.contains("->")){
                String[] nodes = line.split("->");
                map.put(nodes[0].charAt(0), nodes[1].charAt(0));
            }
            else if(line.contains(",")){
                Set<Character> startSet = new HashSet<Character>();
                String[] starts = line.split(",");
                for(String s : starts){
                    startSet.add(s.charAt(0));
                }       
                startSets.add(startSet);         
            }
            else{
                break;
            }
        }
        input.close();
    }

}
