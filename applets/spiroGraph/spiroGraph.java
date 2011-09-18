import java.awt.*;
import javax.swing.*;
 
public class spiroGraph extends JApplet {
 
    int width, height;
    Image backbuffer;
    Graphics backg;
 
    int O = 4;
    int R = 100;
    int r = 10;
 
 
    public void init() {
        width = getSize().width;
        height = getSize().height;
 
        backbuffer = createImage(width, height);
        backg = backbuffer.getGraphics();
        backg.setColor(Color.black);
 
        backg.fillRect(0, 0, width, height);
        //backg.setColor(Color.white);
    }
    public void start() {
        //Accidently Left Blank
    }
 
    public void update(Graphics g) {
        g.drawImage(backbuffer, 0, 0, this);
        g.setColor (Color.white);
 
        int xOld = (int) Math.round((R+r)-(r+O)) + width/2;
        int yOld = (int) height/2;
 
        for (int t = 0; t < 100; t++){
            int xNew = (int) Math.round((R+r)*Math.cos(t)-(r+O)*Math.cos(((R+r) / r)*t)) + width/2;
            int yNew = (int) Math.round((R+r)*Math.sin(t)-(r+O)*Math.sin(((R+r) / r)*t)) + height/2;
 
            g.drawLine(xOld, yOld, xNew, yNew);
 
            xOld = xNew;
            yOld = yNew;
 
            System.out.println(xNew + yNew);
        }
    }
 
    public void paint(Graphics g) {
        update(g);
    }
}
