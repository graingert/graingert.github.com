int vert=0;
int hos=0;
int num=0;
int frame=0;

void setup()
{
  size(300,300, P2D);
}

void draw()
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
