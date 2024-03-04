import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pool {
    private Component canvas;
    private double Radius = 30;
    private double X;
    private double Y;
    public Pool(){
        X = 0;
        Y = 0;
    }
    public Pool(Component c, double Xcord, double Ycord){
        this.canvas = c;
        X = Xcord;
        Y = Ycord;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.black);
        g2.fill(new Ellipse2D.Double(X-Radius,Y-Radius,Radius*2,Radius*2));

    }

    public double GetRadius(){
        return Radius;
    }
    public double GetX(){
        return X;
    }
    public double GetY(){
        return Y;
    }

}
