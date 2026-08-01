public class LockTwo{
    private volatile int victim;


    public void lock(int i) {
        victim = i;
        while (victim == i) {
        }
    }

    public void unlock() {
    }
}
