import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectCanvas extends JPanel {
    private ArrayList<Ball> redBalls = new ArrayList<>();
    private ArrayList<Ball> blueBalls = new ArrayList<>();
    private ArrayList<Pool> pools = new ArrayList<>();

    public void addRed(Ball b){
        this.redBalls.add(b);
    }
    public void addBlue(Ball b){
        this.blueBalls.add(b);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(int i=0; i<blueBalls.size();i++){
            Ball b = blueBalls.get(i);
            if(b != null){
                b.draw(g2);
            }
        }
        for(int i=0; i<redBalls.size();i++){
            Ball b = redBalls.get(i);
            if(b != null){
                b.draw(g2);
            }
        }
        for(int i=0; i<pools.size();i++) {
            Pool p = pools.get(i);
            p.draw(g2);
        }
    }

    public void add(Pool p) {this.pools.add(p);}

    public ArrayList<Pool> getPools(){
        return pools;
    }
    public synchronized  void delBall(Ball b){

        blueBalls.remove(b);
        redBalls.remove(b);
        Score.increment();
    }
}
