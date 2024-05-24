public class Counter {
    private final static Object lock = new Object();
    private static int count = 0;

    public void increment() {
        Counter.count++;
    }

    public void decrement() {
        Counter.count--;
    }

    public synchronized void incrementMethSync() {
        Counter.count++;
    }

    public synchronized void decrementMethSync() {
        Counter.count--;
    }

    public void incrementBlockSync() {
        synchronized (this) {
            Counter.count++;
        }
    }

    public void decrementBlockSync() {
        synchronized (this) {
            Counter.count--;
        }
    }

    public static void incrementLockSync()
    {
        synchronized (lock) {
            Counter.count++;
        }
    }

    public static void decrementLockSync()
    {
        synchronized (lock) {
            Counter.count--;
        }
    }
    public int getCount(){
        return count;
    }
    public void reset(){count = 0;}
}
