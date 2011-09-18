int vert=0;
int hos=0;
PFont font;
String scrollText = "Hello";

void setup()
{
  size(600,600, P2D);
 
  
  font = loadFont("Eureka-90.vlw"); 
  textFont(font); 
  // Draw text more accurately and efficiently.
  textMode(SCREEN);
  textAlign(CENTER);
}

void draw()
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
