ArrayList<Particle> particles;

void setup() {
  size(500, 500);
  particles = new ArrayList<Particle>();
}

void draw() {
  for (int i = particles.size()-1; i >= 0; i--) {
    Particle p = particles.get(i);
    p.run();
    if (p.isDead()) {
      particles.remove(i);
    }
  }


  if (mousePressed) { 
    particles.add(new Particle(mouseX, mouseY));
  }

  println(particles.size());
}

class Particle {

  int x;
  int y;
  float weight;
  float lifespan;

  Particle(int _x, int _y) {
    x = _x;
    y = _y;

    weight = random(5, 15);
    lifespan = random(100, 400);
  }

  void run() {
    display();
    update();
  }

  void display() {
    weight = constrain(weight, 2, 100);

    stroke(0);
    strokeWeight(weight);
    point(x, y);
  }

  void update() {
    if (weight > 0.5) {
      weight -= 0.1;
    }
        
    y++;
    lifespan -= 1;
  }

  // Is the particle still useful?
  boolean isDead() {
    if (lifespan < 0.0) {
      return true;
    } else {
      return false;
    }
  }
}
