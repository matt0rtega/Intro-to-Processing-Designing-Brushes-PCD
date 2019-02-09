// Build 01-1 - Shapes & Colors

PImage img;

void setup(){
  // I run once
  println("Run once");
  
  size(500, 500);
  background(250);

  img = loadImage("texture.png");
}

void draw(){
  // I run continuously
  println("Run again and again");
  
  fill(255, 0, 0);
  ellipse(100, 100, 100, 100);

  fill(255, 0, 255);
  rect(200, 100, 100, 100);

  fill(0, 0, 255);
  line(350, 100, 400, 400);

  fill(0);
  point(mouseX, mouseY);

  tint(255, 255, 0);
  image(img, mouseX, mouseY, 100, 100);
}

