package PenguinGameInAntarctica;

public class PlayerPenguin extends Penguin {
    public PlayerPenguin(int x, int y) {
        super(x, y);
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

    public boolean move(int newX, int newY){
        antarktis[this.x][this.y] = null;
        int[] temp = matrixBounds(newX,newY);

        if(antarktis[temp[0]][temp[1]] != null){
            if(antarktis[temp[0]][temp[1]].canEat(this)){
                return true;
            }else if(antarktis[temp[0]][temp[1]].isPenguin()){
                return true;
            }else{
                temp[0] = x;
                temp[1] = y;
            }
        }

        antarktis[x][y] = null;
        this.x = temp[0];
        this.y = temp[1];
        antarktis[temp[0]][temp[1]] = this;

        return false;
    }
}
