import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count: " + counter.getCount());

        //---------------------------------
        counter.reset();

        Thread incrementThreadBlockSync = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementBlockSync();
            }
        });

        Thread decrementThreadBlockSync = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrementBlockSync();
            }
        });

        incrementThreadBlockSync.start();
        decrementThreadBlockSync.start();

        try {
            incrementThreadBlockSync.join();
            decrementThreadBlockSync.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count block synchronized: " + counter.getCount());

        //---------------------------------

        counter.reset();

        Thread incrementThreadMethSync = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementMethSync();
            }
        });

        Thread decrementThreadMethSync = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrementMethSync();
            }
        });

        incrementThreadMethSync.start();
        decrementThreadMethSync.start();

        try {
            incrementThreadMethSync.join();
            decrementThreadMethSync.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count method synchronized: " + counter.getCount());

        //---------------------------------

        counter.reset();

        Thread incrementThreadLockSync = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementLockSync();
            }
        });

        Thread decrementThreadLockSync = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrementLockSync();
            }
        });

        incrementThreadLockSync.start();
        decrementThreadLockSync.start();

        try {
            incrementThreadLockSync.join();
            decrementThreadLockSync.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count lock synchronized: " + counter.getCount());
    }
}
