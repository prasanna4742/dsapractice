import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


// https://www.youtube.com/watch?v=zCezJ8QkUL4
/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class BPActualProblem {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    
    //These are SLLs but the format is DAG, so better store the graph in map format.
    //Map is char,char becasue from each node there's path to only at most one node  
    final Map<Character, Character> sllMap = new HashMap<Character, Character>();
    
    //A List of set for storing all starting points.
    //Set for all points becasue if duplicates starting points are given, it'll be handled
    //List for start point sets becasue order is expecected to be maintained in output.
    final List<Set<Character>> startNodeList = new ArrayList<Set<Character>>();
    
    //Read from terminal and fill up initial data structures
    readInput(sllMap, startNodeList);
    
    //Find the intersections now
    findIntersection(sllMap, startNodeList);
  }
  
  //Find intersetcions across all input start point sets
  private static final void findIntersection(final Map<Character, Character> sllMap, final List<Set<Character>> startNodeList){  
    for(Set<Character> startNodeSet : startNodeList){
      //Code from below method can be merged here but splitting for clarity and to maintain the flow. 
      findIntersectionForEachStartSet(sllMap, startNodeSet);
    }    
  }

  //Find intersetcions across every input start point set
  private static final void findIntersectionForEachStartSet(final Map<Character, Character> sllMap, final Set<Character> startNodeSet){  
    
    //New set for each start set becasue we do not know how much we traveres last time, so cannot reuse
    final Set<Character> visitedNodes = new HashSet<Character>();
    boolean intersectionFound = false;
    
    for(final Character c : startNodeSet){
      intersectionFound = visit(c, visitedNodes, sllMap);
      //It's important to break here becasue if there are 5 start points and we found intersection within first two SLLs then no need to continue.
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
  
  // The core logic of cycle detection and intersetcion finding. 
  private static final boolean visit(final Character c, final Set<Character> visitedNodes, final Map<Character, Character> sllMap){          
    // Overall logic is -
    // 1. we need to stop traversing if there's a cycle.
    // The Challenge text says throw an error for cycle but the youtube video link mentioned that stop traversing and continue to next start node.
    // I'm going with youtube video since I'm trying to implement logic as per what's explained in the video.
    // 2. Then with each startpoint add the node in a set of visited nodes, this set is common across all start points becasue we need to find intersection across SLLs against those start points.
    // If the node already exists, intersection detected return, if you finish the SLL without breaking then no intersection.
    // 3. When visiting each node check it does not create a cycle within given SLL, we cannot use common visitied node set here becasue if the node repeats there we do not know whethere that's 
    // becasue of cycle or intersection, hence maintain another set per SLL just to detect cycle.
    // 4. Traverse each SLL using Queue becasue we cannot use recursion, so this is similar to BFS.
    // 5. Time complexity of this algo - 
    // If say from three given starting points, we have linked lists of length m,n,k, n being greatest length
    // Becasue we are simply traversing all linked lists only once (There's no nested loop, the loop is there only for reading starting points and starting traversal)
    // So worst case time complexity is M(m+n+k) = O(n)    
    
    //To detect cycle within a given SLL
    final Set<Character> currentSLLNodes = new HashSet<Character>();
    
    //For SLL traversal
    final Queue<Character> sllNodes = new ArrayDeque<Character>();
    
    //Add first char to the Q, to get started with traversal
    sllNodes.offer(c);
    
    while(!sllNodes.isEmpty()){
      final Character currNode = sllNodes.poll();
      
      //First check cycle
      if(currentSLLNodes.contains(currNode)){
        break;
      }
      
      //No cycle detected, let's continue
      //Add to currentSLLNodes for future cycle detection
      currentSLLNodes.add(currNode);
        
      //Let's check for intersection now
      if(visitedNodes.contains(currNode)){
        // Stop traversing and simply return true.
        // Becasue visitedNodes is common across all SLLs, node found here means intersection with one of the lists
        return true;
      }
      
      //No intersection found, let's add to visitedNodes
      visitedNodes.add(currNode);
      
      //Now, move to next node
      final Character nextNode = sllMap.get(currNode);
      if(nextNode != null){
        sllNodes.offer(nextNode);
      }
    }
    
    //Loop completed means we finshed SLL traversal from given startpoint without finiding an intersection
    return false;    
  }
  
  
  //Read the input and prepare data structures
  private static final void readInput(final Map<Character, Character> sllMap, final List<Set<Character>> startNodeList) 
    throws IOException {
    final InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    final BufferedReader in = new BufferedReader(reader);    
    String line;
    while ((line = in.readLine()) != null) {
      //System.out.println(line);
      
      final String[] nodes = line.split("->");
      if( nodes != null && nodes.length > 1){
        sllMap.put(nodes[0].charAt(0), nodes[1].charAt(0));
      }
      else{
        final String[] startPoints = line.split(",");
        if( startPoints != null && startPoints.length  >1){          
          Set<Character> startSet = new HashSet<Character>();
          for( String s : startPoints){
            startSet.add(s.charAt(0));
          }
          startNodeList.add(startSet);          
        }
        else{
          //Break for invalid input
          break;
        }
      }        
    }
    in.close();
    reader.close();
    //For checking if I formed SLLs and start node sets correctly
    //System.out.println(sllMap.toString());
    //System.out.println(startNodeList.toString());
  }
}
