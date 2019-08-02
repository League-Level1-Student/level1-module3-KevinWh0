
public class car{
  int x = (int) random(1);
  int y = (int) random(height-40);
  int speed = (int) random(5,10);
  int xVel = 10;
  int size = 15;
  void setupCar(){
    x = (int) random(1);
     x = x * width; 
     y = (int) random(height-40);
      //speed = (int) (random(5));
  }
  int getX(){
    return x;
  }
    int getY(){
    return y;
  }
  int getSize(){
   return size; 
  }
  void drawCar(){
        ellipse(x,y,15,15);
        if(xVel >0){
       image(carRight,x-40,y-40,80,80);
        }else{
       image(carLeft,x-40,y-40,80,80);

        }
        
  }
  void drive(){
    this.drawCar();
    x+=xVel;
    if(x > width+15 || x < -15){
      xVel = -xVel;
    }
  }
  
}
