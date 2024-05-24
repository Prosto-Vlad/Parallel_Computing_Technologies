public class ThreadsAsync extends Thread{
    private String symbol;
    public ThreadsAsync(String symbol){
        this.symbol = symbol;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
