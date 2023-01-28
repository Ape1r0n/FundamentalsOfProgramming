package PenguinGameInAntarctica;

import java.awt.Toolkit;
import java.io.File;

public class Penguin extends Animal {
  static String filename = "tux.png";

  public Penguin(int x, int y) {
    super(x, y);

    f = new File(filename);
    image = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
  }

  protected boolean isPenguin(){
    return true;
  }

  public boolean canEat(Animal animal) {
    return animal.eatenBy(this);
  }

  protected boolean eatenBy(Penguin penguin){
    return false;
  }

  protected boolean eatenBy(PlayerPenguin playerPenguin){
    return false;
  }

  protected boolean eatenBy(Whale whale){
    return true;
  }

  protected boolean eatenBy(LeopardSeal leopardSeal){
    return false;
  }

  protected boolean eatenBy(Fish fish){
    return false;
  }
}
