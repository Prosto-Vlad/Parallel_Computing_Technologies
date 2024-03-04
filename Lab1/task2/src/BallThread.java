import java.awt.*;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball){
        b = ball;
    }
    @Override
    public void run(){
        try{
            for(int i=1; i<10000; i++){
                b.move();

                if(b.isPooled()){
                    this.interrupt();
                    Score.increment();
                    return;
                }

                System.out.println("Thread name = "
                        + Thread.currentThread().getName() + " -- " + b.isPooled());
                Thread.sleep(5);

            }
        } catch(InterruptedException ex){
        }
    }

}
