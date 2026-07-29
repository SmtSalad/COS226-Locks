public class LockTwo implements Lock{
    private volatile int victim;

    @Override
    public void lock() {
        int i = (int)Thread.currentThread().threadId();
        victim = i;

        while (victim == i) {
        }
    }
@Override
    public void unlock() {
    }
}
