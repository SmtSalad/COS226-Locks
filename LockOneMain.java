public class LockOneMain {
    static LockOne lock = new LockOne();
    static int count = 0;

    public static void main(String [] args) throws InterruptedException{
        Runnable inc0 = new Runnable() {
        
            public void run(){
                for(int i = 0; i < 50; i++){
                    lock.lock(0); //enters Critical Section
                    ++count;
                    lock.unlock(0); //exits Critical section and gives other thread a turn
                }
            }
        };

        Runnable inc1 = new Runnable() {
        
            public void run(){
                for(int i = 0; i < 50; i++){
                    lock.lock(1); //enters Critical Section
                    ++count;
                    lock.unlock(1); //exits Critical section and gives other thread a turn

                }
            }
        };
        
        Thread t0 = new Thread(inc0);
        Thread t1 = new Thread(inc1);

        t0.start(); //executes their code blocks
        t1.start();
        t0.join(); //makes main thread wait for these threads to finish executing 
        t1.join();

        System.out.println("LockOne worked successfully. Final count is:" + count); //when testing change itteration amounts
    }
 //if terminal freezes then threads are in deadlock.
}
