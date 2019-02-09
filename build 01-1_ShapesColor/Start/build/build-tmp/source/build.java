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

public void setup(){
  // I run once
  println("Run once");
  
  
  background(250);

  img = loadImage("texture.png");
}

public void draw(){
  // I run continuously
  println("Run again and again");
  
  ellipse(100, 100, 100, 100);

  rect(200, 100, 100, 100);

  line(350, 100, 400, 400);

  point(mouseX, mouseY);

  tint(255, 0, 0);
  image(img, mouseX, mouseY, 100, 100);
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
