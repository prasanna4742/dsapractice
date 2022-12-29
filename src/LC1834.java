import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1834 {
    public static void main(String[] args) {
        // Arrays.stream(getOrder(new int[][]{{1,2},{2,4},{3,2},{4,1}})).forEach(System.out::print);
        // System.out.println();
        // Arrays.stream(getOrder(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}})).forEach(System.out::print);
        // System.out.println();
        Arrays.stream(getOrder(new int[][]{{5,2},{7,2},{9,4},{6,3},{5,10},{1,1}})).forEach(System.out::print);

    }

    public static int[] getOrder(int[][] tasks) {
        int[] retArr = new int[tasks.length];
        int index = 0;
        PriorityQueue<Task> startQ = new PriorityQueue<Task>((x,y)-> x.enQ - y.enQ);
        PriorityQueue<Task> waitQ = new PriorityQueue<Task>((x,y)-> x.wait == y.wait?x.index - y.index:x.wait-y.wait );
        for(int i=0; i<tasks.length; i++){
            startQ.offer(new Task(tasks[i][0], tasks[i][1], i));
        }

        int time = startQ.peek().enQ;
        while(!startQ.isEmpty()){

            while(!startQ.isEmpty() && startQ.peek().enQ <= time){
                waitQ.offer(startQ.poll());
            }

            if(!waitQ.isEmpty()){
                Task currTask = waitQ.poll();
                retArr[index++] = currTask.index;
                time = time + currTask.wait;    
            }
            else if(!startQ.isEmpty()){
                time = startQ.peek().enQ;
            }
        }

        while(!waitQ.isEmpty()){
            retArr[index++] = waitQ.poll().index;
        }
        return retArr;
    } 
}

class Task{
    public int enQ;
    public int wait;
    public int index;
    public Task(int enQ, int wait, int index){
        this.enQ = enQ;
        this.wait = wait;
        this.index = index;
    }
}

