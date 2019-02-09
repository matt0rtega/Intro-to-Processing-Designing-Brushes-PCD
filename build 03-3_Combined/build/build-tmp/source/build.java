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

int[] palette = {0xff56121F, 0xff73737D, 0xff181A1A, 0xffD47450, 0xffE882E8, 0xffE1489B, 0xff325870, 0xff916A7A, 0xff9B9560, 0xff5A6C5D, 0xff77BCC6, 0xffACAC75, 0xffCEA47F, 0xff998059, 0xff658F22, 0xff010000, 0xff29AABA, 0xff258A83, 0xff28A97F, 0xffC1361A, 0xff1F4A56, 0xff8D7C2A, 0xffAC458F, 0xff252B2C, 0xffB87C64};
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
