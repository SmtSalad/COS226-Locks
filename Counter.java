

public class Counter {

    private int count = 0;
    
    private Lock lock;

    public void increment() {
        
        lock.lock(); 
        try {
            // CS
            count++;
            System.out.println(Thread.currentThread().threadId() + " incremented");
        } finally {
           
            lock.unlock(); 
        }
    }

    public int getCount() {
        return count;
    }
}
