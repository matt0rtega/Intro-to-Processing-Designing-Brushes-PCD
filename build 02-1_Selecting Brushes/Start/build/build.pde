// Build 02-1 - Built-in Variables, Conditions, Loops, and Random Numbers

void setup() {
  // I run once
  println("Run once");

  size(500, 500);
  background(255);
}

void draw() {

  if (mousePressed) {
    stroke(0);
    strokeWeight(2);
    point(mouseX, mouseY);
  }

  float dist = dist(pmouseX, pmouseY, mouseX, mouseY);

  if (keyPressed) {

    // Brush 1 - Line with Variable Weight
    if (key == '1') {
      strokeWeight(dist);
      line(pmouseX, pmouseY, mouseX, mouseY);
    }
    
    // Brush 2 -  Line with Random Direction
    
    float range = dist;
    
    float posx = mouseX+random(-range, range);
    float posy = mouseY+random(-range, range);
    
    line(pmouseX, pmouseY, posx, posy);
  }



  // I run continuously
  println("Run again and again");
}
