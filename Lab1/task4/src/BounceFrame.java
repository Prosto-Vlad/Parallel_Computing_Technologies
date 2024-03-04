import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public static final int COUNT = 100;
    public static boolean par = false;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        

        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i < COUNT; i++) {
                            Ball b;
                            if(par){
                                b = new Ball(canvas, Color.red);
                                par = false;
                                canvas.add(b);
                            }
                            else {
                                b = new Ball(canvas, Color.blue);
                                par = true;
                                canvas.add(b);
                            }
                            BallThread thread = new BallThread(b);
                            thread.start();
                            System.out.println("Thread name = " +
                                    thread.getName());
                            try {
                                thread.join();
                            } catch (InterruptedException ignored) { }
                        }
                    }
                });
                t.start();
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

}
