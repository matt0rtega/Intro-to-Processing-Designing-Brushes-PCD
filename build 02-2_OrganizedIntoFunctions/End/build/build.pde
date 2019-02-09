// Build 02 - Organized into Functions

PImage img;

void setup(){
  size(500, 500);
  background(250);
  
  img = loadImage("texture.png");
}

void draw(){
  if(mousePressed){
    stroke(0);
    strokeWeight(2);
    point(mouseX, mouseY);
      if(keyPressed){
      // Brush 1 - Line with Variable Weight
      if(key == '1') lineBrush();
      // Brush 2 - Line with Random Direction
      if(key == '2') randomLineBrush();
      // Brush 3 - Spray
      if(key == '3') sprayBrush();
      // Brush 4 - Image Brush
      if(key == '4') imageBrush();
    }
  }

}

void lineBrush(){
  float dist = dist(pmouseX, pmouseY, mouseX, mouseY);
  strokeWeight(dist);
  line(pmouseX, pmouseY, mouseX, mouseY);
}

void randomLineBrush(){
  float randx = random(-50, 50);
  float randy = random(-50, 50);

  float posx = mouseX + randx;
  float posy = mouseY + randy;

  line(pmouseX, pmouseY, posx, posy);
}

void sprayBrush(){
  float dist = dist(pmouseX, pmouseY, mouseX, mouseY);

  for (int i = 0; i < 50; i++) {

          // Needed for square shape
          float rangex = random(dist);
          float rangey = random(dist);

          float randx = random(-rangex, rangex);
          float randy = random(-rangey, rangey);
          
          ellipse(mouseX + randx, mouseY + randy, 2, 2);
        }
}

void imageBrush(){
    tint(255, 0, 0);
    imageMode(CENTER);
    image(img, mouseX, mouseY, 100, 100);
    print("Image brush");
}

void mousePressed(){
  println("Mousepressed once");
}

void keyPressed(){
  println("Keypressed once");
}