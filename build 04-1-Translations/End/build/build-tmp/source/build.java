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

float rot = 0;

public void setup(){
  // I run once
  println("Run once");
  
  
  background(0);

  
}

public void draw(){
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

  rot += 0.01f;
}




// Start

// void setup(){
//   // I run once
//   println("Run once");
  
//   size(500, 500);
//   background(0);
// }

// void draw(){
//   // I run continuously
//   println("Run again and again");
// }
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
