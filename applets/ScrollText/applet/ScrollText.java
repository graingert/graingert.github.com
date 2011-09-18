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

public class ScrollText extends PApplet {

int vert=0;
int hos=0;
PFont font;
String scrollText = "Hello";

public void setup()
{
  size(600,600, P2D);
 
  
  font = loadFont("Eureka-90.vlw"); 
  textFont(font); 
  // Draw text more accurately and efficiently.
  textMode(SCREEN);
  textAlign(CENTER);
}

public void draw()
{
  background(51);
  text(scrollText,vert,hos);
  if (vert < width){
    vert+=10;
  }else if (hos <width){
    vert=0;
    hos+=10;
  } else {
    vert =0;
    hos=0;
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "ScrollText" });
  }
}
