public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        ThreadsAsync t1 = new ThreadsAsync("-");
        ThreadsAsync t2 = new ThreadsAsync("|");
        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println();
        for (int j = 0; j < 100; j++) {
            System.out.print("+");
        }
        System.out.println();
        System.out.println();


        Synchronize synchronize = new Synchronize();
        ThreadsSync st1 = new ThreadsSync("|", true, synchronize);
        ThreadsSync st2 = new ThreadsSync("-", false, synchronize);
        Thread t3 = new Thread(st1);
        Thread t4 = new Thread(st2);
        t3.start();
        t4.start();


    }
}
