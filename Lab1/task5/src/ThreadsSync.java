public class ThreadsSync implements Runnable  {
    private String symbol;
    private boolean isRun = true;
    private Synchronize sync;

    public ThreadsSync(String symbol, boolean isRun, Synchronize sync){
        this.isRun = isRun;
        this.sync = sync;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        while (!sync.getStop()) {
            sync.waitThread(isRun, symbol);
        }
    }
}
