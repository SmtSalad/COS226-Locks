public class LockTwoMain {

    static LockTwo lock = new LockTwo();
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable run0 = new Runnable() {

           
            public void run(){
                for (int i = 0; i < 5; i++) {
                    lock.lock(0); //enter cs
                    ++count;
                    System.out.println(Thread.currentThread().getName() + "   " + count);
                    lock.unlock(); //exit cs
                }
            }
        };

        Runnable run1 = new Runnable() {
            
        
            public void run(){
                for (int i = 0; i < 5; i++) {
                    lock.lock(1); //enter cs
                    ++count;
                    System.out.println( Thread.currentThread().getName() + "   " + count);
                    lock.unlock(); //exit cs
                }
            }
        };


        Thread t0 = new Thread(run0);
        Thread t1 = new Thread(run1);


        // run() starts the threads so they both start running, and can run concurrently
        t0.start();
        t1.start();
       
        // (there is going to be a deadlock once t0 finishes its execution before t1 bc t1 will be stuck waiting for t0 to be the victim again)

      
      

    }
}
