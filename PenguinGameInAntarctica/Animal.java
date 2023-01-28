package PenguinGameInAntarctica;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.File;

public abstract class Animal {
  protected int x, y;
  static String filename;
  protected File f;
  protected Image image;
  protected boolean dead = false;

  protected static Animal[][] antarktis;

  public Animal(int x, int y) {
    this.x = x;
    this.y = y;
  }

  protected boolean noHunter(int x, int y){
    int[][] movementArray = {{-1,0},{0,-1},{1,0},{0,1}};
    for(int i=0; i<movementArray.length; i++){
      int[] temp = matrixBounds(x+movementArray[i][0],y+movementArray[i][1]);
      Animal tempLocation = antarktis[temp[0]][temp[1]];
      if(tempLocation != null){
        if(tempLocation.canEat(this)){
          return false;
        }
      }
    }
    return true;
  }

  protected boolean isWhale(){
      return false;
  }
  protected boolean isPenguin(){
    return false;
  }

  protected boolean isFish(){
    return false;
  }

  protected void killOrEatOrWhatever(){
    this.dead = true;
  }
  protected boolean isTroop(){
    return  this.dead;
  }
  public int[] matrixBounds(int x, int y){
    if(x < 0) x = antarktis.length - 1;
    else if(x >= antarktis.length) x = 0;
    if(y < 0) y = antarktis[0].length - 1;
    else if(y >= antarktis[0].length) y = 0;
    return new int[]{x,y};
  }

  public void move() {
    int[][] movementArray = {{-1,0},{0,-1},{1,0},{0,1}};
    int currentX = x, currentY = y;
    antarktis[x][y] = null;
    for(int i=0; i<movementArray.length; i++){
      int[] temp = matrixBounds(x+movementArray[i][0],y+movementArray[i][1]);
      if(antarktis[temp[0]][temp[1]] != null && (this.canEat(antarktis[temp[0]][temp[1]])) && this.noHunter(temp[0],temp[1])){
        antarktis[temp[0]][temp[1]].killOrEatOrWhatever();
        this.x = temp[0];
        this.y = temp[1];
        antarktis[temp[0]][temp[1]] = this;
        break;
      }
    }
    if(currentX == x && currentY == y){
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

  public abstract boolean canEat(Animal animal);

  protected abstract boolean eatenBy(Penguin penguin);
  protected abstract boolean eatenBy(PlayerPenguin playerPenguin);
  protected abstract boolean eatenBy(Whale whale);
  protected abstract boolean eatenBy(LeopardSeal leopardSeal);
  protected abstract boolean eatenBy(Fish fish);

  public static void setAntarktis(Animal[][] antarktis) {
    Animal.antarktis = antarktis;
  }
  // Graphics Stuff - You don't have to do anything here

  private void paintSymbol(Graphics g, Color c, int height, int width) {
    GradientPaint gradient = new GradientPaint(15, 0, c, width, 0, Color.LIGHT_GRAY);
    ((Graphics2D) g).setPaint(gradient);
    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.fillOval((int) (width * 0.3), (int) (height * 0.3), (int) (width * 0.5),
            (int) (height * 0.5));
  }

  public void draw(Graphics g, int height, int width) {
    if (image == null) {
      paintSymbol(g, Color.YELLOW, height, width);
      return;
    }
    ((Graphics2D) g).drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(null),
            image.getHeight(null), null);
  }
}
