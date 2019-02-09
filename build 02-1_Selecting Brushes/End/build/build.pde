// Build 02-1 - Built-in Variables, Conditions, Loops, and Random Numbers

PImage img;

void setup(){
  // I run once
  println("Run once");
  
  size(500, 500);
  background(250);
  
  img = loadImage("texture.png");
}

void draw(){

  stroke(0);
  strokeWeight(2);

  float dist = dist(pmouseX, pmouseY, mouseX, mouseY);

  if(mousePressed){
    point(mouseX, mouseY);

      if(keyPressed){
      //point(mouseX, mouseY);

      // Brush 1 - Line with Variable Weight
      if(key == '1'){

        println(dist);

        strokeWeight(dist);
        line(pmouseX, pmouseY, mouseX, mouseY);
      }

      // Brush 2 - Line with Random Direction
      if(key == '2'){
        float randx = random(-50, 50);
        float randy = random(-50, 50);

        float posx = mouseX + randx;
        float posy = mouseY + randy;

        line(pmouseX, pmouseY, posx, posy);
      }

      // Brush 3 - Spray
      if(key == '3'){
        for (int i = 0; i < 50; i++) {

          // Needed for square shape
          float rangex = random(dist);
          float rangey = random(dist);

          float randx = random(-rangex, rangex);
          float randy = random(-rangey, rangey);
          
          ellipse(mouseX + randx, mouseY + randy, 2, 2);
        }
      }

      if(key == '4'){
          tint(255, 0, 0);
          imageMode(CENTER);
          image(img, mouseX, mouseY, 100, 100);
        }

    } else {

    }
  }

}

void mousePressed(){
  println("Mousepressed once");
}

void keyPressed(){
  println("Keypressed once");
}