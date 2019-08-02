PImage frog;
PImage carRight;
PImage carLeft;

int frogX = 0;
int frogY = 0;
int speed = 50;
car a = new car();
car b = new car();
car c = new car();
car d = new car();

void setup() {
  size(800, 800);
  //back = loadImage("froggerBackground.png");
  carLeft = loadImage("carLeft.png");
  carRight = loadImage("carRight.png");
  frog = loadImage("frog.png");


  frogX = width/2;
  frogY = height-20;
  a.setupCar();
  b.setupCar();

  c.setupCar();

  d.setupCar();
}
void frog() {

  fill(0);
  ellipse(frogX, frogY, 10, 10);
  image(frog, frogX-40, frogY-40, 80, 80);
}
boolean intersects(car car) {
 if ((frogY > car.getY() && frogY < car.getY()+40) && (frogX > car.getX() && frogX < car.getX()+60)) {
   return true;
  }
 else  {
  return false;
 }
}
void draw() {

  background(0);
  frog();
  a.drive();
  b.drive();
  c.drive();
  d.drive();
  
  if(intersects(a) || intersects(b) || intersects(c) || intersects(d)){
    print("dead");
    noLoop();
  }

}


void keyPressed()
{
  if (key == CODED) {
    if (keyCode == UP)
    {
      //Frog Y position goes up
      frogY-=speed;
    } else if (keyCode == DOWN)
    {
      //Frog Y position goes down 
      frogY+=speed;
    } else if (keyCode == RIGHT)
    {
      //Frog X position goes right
      frogX+=speed;
    } else if (keyCode == LEFT)
    {
      //Frog X position goes left
      frogX-=speed;
    }
  }
}
