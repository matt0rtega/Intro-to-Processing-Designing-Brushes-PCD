// Build 04 - Translations


float rot = 0;

void setup(){
  // I run once
  println("Run once");
  
  size(500, 500);
  background(0);

  
}

void draw(){
  // I run continuously
  println("Run again and again");

  pushMatrix();
  rectMode(CENTER);
  translate(mouseX, mouseY);
  rotate(rot);
  rect(0, 0, 100, 100);

  rect(100, 400, 100, 100);
  popMatrix();

  rect(width/2, height/2, 100, 100);

  rot += 0.01;
}