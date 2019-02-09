import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

PImage img;

int[] palette = {0xff00162B, 0xff000000, 0xff000000, 0xff000000, 0xff000000, 0xff000000, 0xff000000, 0xff380000, 0xff380000, 0xff380000, 0xff000000, 0xff000000, 0xff000000, 0xff000000, 0xff2D0000, 0xff2D0000, 0xff2D2A7F, 0xff2D0000, 0xff380000, 0xff380000, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff2D0000, 0xff2C49DF, 0xff2D0000, 0xff2D0000, 0xff2D0000, 0xff2C1228, 0xff3760FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff2D0000, 0xff2D0000, 0xff2D1122, 0xff2D0103, 0xff00A6FF, 0xff375FFF, 0xff49C0FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff2D0000, 0xff2D0000, 0xff00A6FF, 0xff00A6FF, 0xff375EFF, 0xffB7E6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff2D0000, 0xff2D0000, 0xff00A6FF, 0xff00A6FF, 0xff375EFF, 0xff97DBFF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff2D0207, 0xff2D0206, 0xff00A6FF, 0xff00A6FF, 0xff375EFF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff375FFF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff00A6FF, 0xff2D0001, 0xff2D0001, 0xff039EF3, 0xff380000, 0xff381A4A, 0xff000000, 0xff000000, 0xff000000, 0xff000000, 0xff2D0000, 0xff2D0000, 0xff2D0000, 0xff2D0000, 0xff380000, 0xff380000};
int selectedColor;
int index = 0;

public void setup(){
  
  background(250);
  
  img = loadImage("texture.png");

  selectedColor = palette[index];
}

public void draw(){

  selectedColor = palette[index % palette.length]; // Questions?

  if(mousePressed){
    stroke(selectedColor);
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
      // Brush 5 - Image Brush
      if(key == '5') translateBrush();
    }
  }

  colorPreview();
}

public void colorPreview(){
  // Color preview and Tinting
  float size = 50;
  ellipseMode(CORNER);
  fill(selectedColor);
  noStroke();
  ellipse(16, height - size - 16, size, size);
}

public void translateBrush(){
  pushMatrix();
  rectMode(CENTER);
  translate(mouseX, mouseY);
  rotate(PI/4);
  rect(0, 0, 15, 100);
  popMatrix();
}

public void lineBrush(){
  float dist = dist(pmouseX, pmouseY, mouseX, mouseY);
  stroke(selectedColor);
  strokeWeight(dist);
  line(pmouseX, pmouseY, mouseX, mouseY);
}

public void randomLineBrush(){
  float randx = random(-50, 50);
  float randy = random(-50, 50);

  float posx = mouseX + randx;
  float posy = mouseY + randy;

  stroke(selectedColor);
  line(pmouseX, pmouseY, posx, posy);
}

public void sprayBrush(){
  float dist = dist(pmouseX, pmouseY, mouseX, mouseY);

  fill(selectedColor);
  for (int i = 0; i < 50; i++) {

          // Needed for square shape
          float rangex = random(dist);
          float rangey = random(dist);

          float randx = random(-rangex, rangex);
          float randy = random(-rangey, rangey);
          
          ellipse(mouseX + randx, mouseY + randy, 2, 2);
        }
}

public void imageBrush(){
    tint(selectedColor);
    imageMode(CENTER);
    image(img, mouseX, mouseY, 100, 100);
    print("Image brush");
}

public void mousePressed(){
  println("Mousepressed once");
}

public void keyPressed(){
  println("Keypressed once");

  if(key == 'c') index += 1;
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
