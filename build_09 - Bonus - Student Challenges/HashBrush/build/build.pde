float rot=0;
float size=10;
float spacing = 10;

void setup(){
  background(255);
  size(500, 500);
}

void draw(){
  
  size = random(1, 5);
  spacing = random(1, 10);
  //background(255);
  if(mousePressed){
  translate(mouseX, mouseY);
  rotate(rot);
  for(int i=0; i<5; i++){
    pushMatrix();
    translate(i*spacing - 25, 0);
    line(-size, -size, size, size);
    popMatrix();
  }
  }
}

void keyPressed(){
  rot = random(TWO_PI);
}
