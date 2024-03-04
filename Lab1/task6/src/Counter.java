public class Counter {
    private final static Object lock = new Object();
    private static  int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public synchronized void incrementMethSync() {
        count++;
    }

    public synchronized void decrementMethSync() {
        count--;
    }

    public void incrementBlockSync() {
        synchronized (this) {
            count++;
        }
    }

    public void decrementBlockSync() {
        synchronized (this) {
            count--;
        }
    }

    public static void incrementLockSync()
    {
        synchronized (lock) {
            count++;
        }
    }

    public static void decrementLockSync()
    {
        synchronized (lock) {
            count--;
        }
    }
    public int getCount(){
        return count;
    }
    public void reset(){count = 0;}
}
