public class OddEven {
    public static void main(String[] args) {
        OddEven oe = new OddEven();
        oe.objectMain();
    }

    public void objectMain(){
        Counter cntr = new Counter();
        Thread oPrinter = new Thread(new Printer(false, cntr));
        Thread ePrinter = new Thread(new Printer(true, cntr));
        ePrinter.start();
        oPrinter.start();
    }

    class Counter{
        public int cnt = 1;
    }

    class Printer implements Runnable{

        boolean evenPrinter = true;
        boolean modByResult = true;
        Counter counter;
        String name;
        int max = 100;

        public Printer(boolean evenPrinter, Counter counter){
            this.evenPrinter = evenPrinter;
            if(!evenPrinter){
                this.modByResult = false;
                this.name = "OddPrinter";
            }
            else{
                this.name = "EvenPrinter";
            }
            this.counter = counter;
        }

        @Override
        public void run() {
            while(true){
                synchronized(counter){
                    while( !(counter.cnt % 2 == 0) == modByResult){
                        try {
                            counter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(name+" printing "+counter.cnt);
                    counter.cnt++;
                    counter.notify();
                }
            }
        }
    }
}
