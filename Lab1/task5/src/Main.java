public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        ProjectThreads t1 = new ProjectThreads("-");
        ProjectThreads t2 = new ProjectThreads("|");
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                t1.print();
                t2.print();
            }
            System.out.println();
        }
    }
}
