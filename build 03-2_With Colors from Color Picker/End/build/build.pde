// Build 03-2 - Arrays - With Colors from Color Picker

// This is array - Understanding variables
color[] colors = {#76C3AF, #FFD9DA, #1B1464};
int[] integers = {0, 1, 2};

int variable = 0;
int[] variables;
int[] variables2 = {0, 1, 2};

// Color picker
color[] palette = {#56121F, #73737D, #181A1A, #D47450, #E882E8, #E1489B, #325870, #916A7A, #9B9560, #5A6C5D, #77BCC6, #ACAC75, #CEA47F, #998059, #658F22, #010000, #29AABA, #258A83, #28A97F, #C1361A, #1F4A56, #8D7C2A, #AC458F, #252B2C, #B87C64};

// Global scope
color selectedColor;
int index = 0;

void setup() {
  size(500, 500);
  background(255);

  //colorMode(HSB);
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