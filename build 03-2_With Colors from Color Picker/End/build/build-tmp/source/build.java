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


// This is array - Understanding variables
int[] colors = {0xff76C3AF, 0xffFFD9DA, 0xff1B1464};
int[] integers = {0, 1, 2};

int variable = 0;
int[] variables;
int[] variables2 = {0, 1, 2};

// Color picker
int[] palette = {0xff56121F, 0xff73737D, 0xff181A1A, 0xffD47450, 0xffE882E8, 0xffE1489B, 0xff325870, 0xff916A7A, 0xff9B9560, 0xff5A6C5D, 0xff77BCC6, 0xffACAC75, 0xffCEA47F, 0xff998059, 0xff658F22, 0xff010000, 0xff29AABA, 0xff258A83, 0xff28A97F, 0xffC1361A, 0xff1F4A56, 0xff8D7C2A, 0xffAC458F, 0xff252B2C, 0xffB87C64};

// Global scope
int selectedColor;
int index = 0;

public void setup() {
  
  background(255);

  //colorMode(HSB);
  //colorMode(RGB);

  variables = new int[100];
  selectedColor = palette[index];
}

public void draw() {

  selectedColor = palette[index % palette.length]; // Questions?

  if(mousePressed){
    // RGBA - Default
    ellipseMode(CENTER);
    noStroke();
    strokeWeight(5);
    fill(selectedColor);
    ellipse(mouseX, mouseY, 100, 100);
  }

  // Color preview and Tinting
  float size = 50;
  ellipseMode(CORNER);
  fill(selectedColor);
  noStroke();
  ellipse(16, height - size - 16, size, size);
}

public void keyReleased(){
  println("You just pressed the mouse");

  index += 1;
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
