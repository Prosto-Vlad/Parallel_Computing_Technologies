import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private ArrayList<Pool> pools = new ArrayList<>();

    public void add(Ball b){
        this.balls.add(b);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<balls.size();i++){
            Ball b = balls.get(i);
            b.draw(g2);
        }
        for(int i=0; i<pools.size();i++) {
            Pool p = pools.get(i);
            p.draw(g2);
        }
    }

    public void add(Pool p) {this.pools.add(p);}
}
