// Build 01-02 - Variables & Functions

int x =0;
int y = 0;

void setup(){
  // I run once
  println("Run once");
  
  size(500, 500);
  background(0);
}

void draw(){
  // I run continuously
  println("Run again and again");
  
  ellipse(x, y, 100, 100);
  rect(mouseX, y, 100, 100);

  drawEllipse();

  x = x + 1;
  y = y + 1;

  // If we ever want to know what is going on, your friend println()
  println("x:" + x, "y:" + y);
  print(createInteger(5));
}

// Function
void drawEllipse() {
  ellipse(x, y, 100, 100);
}

// Function with argument
void drawEllipse(float size) {
  ellipse(x, y, 100, 100);
}

// Function that returns something
int createInteger(int i) {
  int num;

  num = i * 10;

  return num;
}