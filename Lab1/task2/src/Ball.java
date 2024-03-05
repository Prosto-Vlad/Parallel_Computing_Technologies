import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

class Ball {
    private ProjectCanvas canvas;
    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private int x = 0;
    private int y= 0;
    private int dx = 2;
    private int dy = 2;

    private boolean pooled = false;

    public Ball(ProjectCanvas c){
        this.canvas = c;

        System.out.println(canvas.getWidth() + " " + canvas.getHeight());
        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = new Random().nextInt(this.canvas.getHeight());
        }else{
            x = new Random().nextInt(this.canvas.getWidth());
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public static void f(){
        int a = 0;
    }

    public void draw (Graphics2D g2){
        g2.setColor(Color.red);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }

    public void move(){
        x+=dx;
        y+=dy;

        ArrayList<Pool> pools = this.canvas.getPools();

        for(Pool pool : pools) {
            if ((Math.pow(this.x - pool.GetX(), 2) + Math.pow(this.y - pool.GetY(), 2) < Math.pow(pool.GetRadius(), 2)))
            {
                this.pooled = true;
                canvas.delBall(this);
                canvas.repaint();
            }
        }

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

    public boolean isPooled(){
        return pooled;
    }
}
