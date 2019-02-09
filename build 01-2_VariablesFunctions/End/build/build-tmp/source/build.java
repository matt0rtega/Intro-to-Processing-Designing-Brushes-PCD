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

// Build 01-02 - Variables and Functions


int x =0;
int y = 0;

public void setup(){
  // I run once
  println("Run once");
  
  
  background(0);
}

public void draw(){
  // I run continuously
  println("Run again and again");
  
  ellipse(x, y, 100, 100);

  drawEllipse();

  x = x + 1;
  y = y + 1;

  // If we ever want to know what is going on, your friend println()
  println("x:" + x, "y:" + y);
  print(createInteger(5));
}

// Function
public void drawEllipse() {
  ellipse(x, y, 100, 100);
}

// Function with argument
public void drawEllipse(float size) {
  ellipse(x, y, 100, 100);
}

// Function that returns something
public int createInteger(int i) {
  int num;

  num = i * 10;

  return num;
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
