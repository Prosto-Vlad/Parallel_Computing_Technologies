public class ProjectThreads extends Thread{
    private String symbol;
    public ProjectThreads(String symbol){
        this.symbol = symbol;
    }

    public void print(){
        try{
            System.out.print(this.symbol);
            Thread.sleep(0);
        } catch (InterruptedException ignored){}
    }

    @Override
    public void run()
    {
        System.out.println();
    }
}
