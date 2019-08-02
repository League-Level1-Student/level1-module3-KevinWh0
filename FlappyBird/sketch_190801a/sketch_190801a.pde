PImage back;
PImage pipeBottom;
PImage pipeTop;
PImage bird;

int gap = 200;
int birdYVelocity = 3;
float gravity = 1;
int upperPipeHeight = (int) random(100, 400);
int lowerY;
float birdY;
int lowerPipeTop = 0;
int birdX = 200;
int pipeX = 1250;
int pipeWidth;
boolean tap = false;
int score = 0;
float speed = 5;
int jumpHeight = 20;
void setup() {
  //fullScreen();
  size(800,800);
  back = loadImage("flappyBackground.jpg");
  pipeBottom = loadImage("bottomPipe.png");
  pipeTop = loadImage("topPipe.png");
  bird = loadImage("bird.png");
  bird.resize(50, 50);
  upperPipeHeight = 0;
  lowerPipeTop = (int) random(pipeBottom.height, height);
  pipeWidth = pipeTop.width;
  upperPipeHeight = pipeTop.width;
}
boolean intersectsPipes() { 

  if (birdY < pipeTop.height && birdX > (pipeX-pipeWidth) && birdX < (pipeX)) {
    return true;
  } else if (birdY>lowerPipeTop && birdX > (pipeX-pipeWidth) && birdX < (pipeX)) {
    return true;
  } else { 
    return false;
  }
}
void applyGrav(){
  if(tap == false){
    birdYVelocity+=1;
  }else{
    //birdYVelocity-=0.8;
    tap = false;
  }
  birdY +=birdYVelocity*gravity;

}
void updatePipes(){
 pipeX-=speed;
 speed+=0.1;
}
void reset(){
  lowerPipeTop = (int) (random(height)-pipeBottom.height);

  //lowerPipeTop = 0;
}
void draw() {
  print(intersectsPipes());
  if(intersectsPipes() == true){
    noLoop();
    reset();
  }
  if(pipeX < 0){
    pipeX = 800;
  }
  //background(back);
  background(255);
  applyGrav();
  updatePipes();
  image (pipeBottom, pipeX, lowerPipeTop);
  image (pipeTop, pipeX, 0, pipeTop.width,pipeTop.height);
  image (bird, birdX, birdY);
}

void mousePressed(){
  birdYVelocity -= ((birdYVelocity)+jumpHeight)*gravity;
  tap = true;
  
}
