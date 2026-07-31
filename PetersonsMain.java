public class PetersonsMain {
    public static void main(String[] args) {
        Counter counter = new Counter(100);//creates a shared counter iwth initial value = 100

        //Thread 0 repeatedly ioncrements the counter and the value 0 is passed as the thread doe the Ptersons Algorithm
    Thread t0 = new Thread(()->{
        for(int i = 0; i < 10; i++){
            counter.increment(0);
        }
    });

    //Thread 1 repeatedly ioncrements the counter and the value 1 is passed as the thread doe the Ptersons Algorithm
    Thread t1 = new Thread(()->{
        for(int i = 0; i < 10; i++){
            counter.decrement(1);
        }
    });

    //starts bpth threads so they execute concurrenlty
    t0.start();
    t1.start();

    

    System.out.println("The value is: "+ counter.getValue());
        
    }
    

}
