package PenguinGameInAntarctica;

import java.awt.Toolkit;
import java.io.File;

public class Fish extends Animal {
  static String filename = "fish.png";

  public Fish(int x, int y) {
    super(x, y);

    f = new File(filename);
    image = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
  }

  protected boolean isFish() {
    return true;
  }

  public boolean canEat(Animal animal) {
    return animal.eatenBy(this);
  }

  protected boolean eatenBy(Penguin penguin) {
    return true;
  }

  protected boolean eatenBy(PlayerPenguin playerPenguin) {
    return true;
  }

  protected boolean eatenBy(Whale whale) {
    return false;
  }

  protected boolean eatenBy(LeopardSeal leopardSeal) {
    return true;
  }

  protected boolean eatenBy(Fish fish) {
    return false;
  }

  public void move() {
    antarktis[x][y] = null;
    int[][] movementArray = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    for(int i=0; i<movementArray.length; i++){
      int[] temp = matrixBounds(x+movementArray[i][0],y+movementArray[i][1]);
      if(antarktis[temp[0]][temp[1]] == null && this.noHunter(temp[0],temp[1])){
        this.x = temp[0];
        this.y = temp[1];
        antarktis[temp[0]][temp[1]] = this;
        break;
      }
    }
  }

}
