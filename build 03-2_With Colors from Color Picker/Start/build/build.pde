// Build 03 - Organized into Functions

// This is array - Understanding variables
color[] colors = {#76C3AF, #FFD9DA, #1B1464};
int[] integers = {0, 1, 2};

int variable = 0;
int[] variables;
int[] variables2 = {0, 1, 2};

// Color picker
color[] palette = {color(255, 0, 255), color(0, 0, 255), color(255, 0, 0)};

// Global scope
color selectedColor;
int index = 0;

void setup() {
  size(500, 500);
  background(255);

  colorMode(HSB);
  //colorMode(RGB);

  variables = new int[100];
  selectedColor = palette[index];
}

void draw() {

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

void keyReleased(){
  println("You just pressed the mouse");

  index += 1;
}