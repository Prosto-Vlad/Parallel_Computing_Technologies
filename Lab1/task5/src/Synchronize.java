public class Synchronize {
    private boolean isRun = true;
    private int count = 0;
    private boolean stop = false;
    private final int MAX_COUNT = 1000;

    public synchronized boolean getStop() {
        return stop;
    }
    public synchronized void waitThread(boolean isRun, String symbol) {

        while (this.isRun != isRun) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print(symbol);

        count++;

        this.isRun = !isRun;

        if (count%100 == 0) {
            System.out.println();
        }

        if (count + 1 == MAX_COUNT) {
            stop = true;
        }
        notifyAll();
    }
}
