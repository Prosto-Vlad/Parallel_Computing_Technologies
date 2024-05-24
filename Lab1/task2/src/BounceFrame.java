import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private ProjectCanvas canvas;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int COUNT = 500;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new ProjectCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JLabel labelScore = new JLabel("Score: " + Score.getScore());

        Score.addListener(new ScoreListener() {
            @Override
            public void action() {
                labelScore.setText("Score: " + Score.getScore());
                labelScore.repaint();
            }
        });

        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createPool(canvas.getWidth(),canvas.getHeight());
                createPool(0,0);
                createPool(canvas.getWidth(),0);
                createPool(0,canvas.getHeight());
                for (int i = 0; i < COUNT; i++) {
                    createBall();
                }
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
        buttonPanel.add(labelScore);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
    private void createPool(double x, double y){
        Pool p = new Pool(x, y);
        canvas.add(p);
    }
    private void createBall(){
        Ball b = new Ball(canvas);
        canvas.add(b);

        BallThread thread = new BallThread(b);
        thread.start();
        System.out.println("Thread name = " +
                thread.getName());
    }


}
