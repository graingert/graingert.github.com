import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class pixel_graph extends PApplet {

int vert=0;
int hos=0;
int num=0;
int frame=0;

public void setup()
{
  size(300,300, P2D);
}

public void draw()
{
  background(51);
  loadPixels();
  for (int y = 0; y < height; y++){
    for (int x = 0; x < width; x++){
      pixels[(width*y)+x]=color ((x^frame + y^frame ));
    }
  }
  updatePixels();
  frame++;
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "pixel_graph" });
  }
}
