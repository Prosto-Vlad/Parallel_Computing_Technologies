import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball {
    private Component canvas;
    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private int x = 0;
    private int y= 0;
    private int dx = 2;
    private int dy = 2;
    private Color color;

    public Ball(Component c, Color color){
        this.canvas = c;
        this.color = color;
        System.out.println(canvas.getWidth() + " " + canvas.getHeight());
        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }

    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x = 0;
            dx = -dx;
        }
        if(x+XSIZE>=this.canvas.getWidth()){
            x = this.canvas.getWidth()-XSIZE;
            dx = -dx;
        }
        if(y<0){
            y=0;
            dy = -dy;
        }
        if(y+YSIZE>=this.canvas.getHeight()){
            y = this.canvas.getHeight()-YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }
}
