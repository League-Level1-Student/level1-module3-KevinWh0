PImage back;
PImage pipeBottom;
PImage pipeTop;
PImage bird;
int birdYVelocity = 30;
int gravity = 1;
int upperPipeHeight = (int) random(100, 400);
int lowerY;
int birdY;
int lowerPipeTop;
int birdX;
int pipeX;
int pipeWidth;

void setup() {
  back = loadImage("flappyBackground.jpg");
  pipeBottom = loadImage("bottomPipe.png");
  pipeTop = loadImage("topPipe.png");
  bird = loadImage("bird.png");
  bird.resize(50, 50);
}
boolean intersectsPipes() { 
  if (birdY < upperPipeHeight && birdX > pipeX && birdX < (pipeX+pipeWidth)) {
    return true;
  } else if (birdY>lowerPipeTop && birdX > pipeX && birdX < (pipeX+pipeWidth)) {
    return true;
  } else { 
    return false;
  }
}
void draw() {
  //background(back);
  background(255);
  image (pipeBottom, 250, 375);
  image (pipeTop, 250, -130);
  image (bird, 250, 300);
}
