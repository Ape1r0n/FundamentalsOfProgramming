package PinguLabyrinth;

public class FindPingu extends Maze {
    static int[][] maze;

    public static void main(String[] args) {
        int width = readInt("Width of the labyrinth?");
        int height = readInt("Height of the labyrinth?");
        int maxDistance = readInt("How far do you dare to go?");
        if (width < 3 || height < 3 || maxDistance < 1) {
            write("Erroneous input!");
            return;
        }
        // always generates the same maze.
        maze = generateStandardPenguinMaze(width, height);
        // generaty random maze.
        // maze = generatePenguinMaze(width, height);
        int penguins = walk(1, 0, maxDistance);
        System.out.println("Rescued pinguins: " + penguins);
    }

    public static int walk(int x, int y, int maxDistance) {
        if(maxDistance < 0) return 0;
        if(x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) return 0;
        if(maze[x][y] == OLD_PATH_ACTIVE || maze[x][y] == WALL) return 0;
        int penguins = 0;
        if(maze[x][y] == PENGUIN) penguins = 1;

        maze[x][y] = PLAYER; // Spawn
        draw(maze);
        maze[x][y] = OLD_PATH_ACTIVE; // Mark your territory, king

        penguins += walk(x+1,y,maxDistance-1); // Let's gooo

        maze[x][y] = PLAYER; // Spawn
        draw(maze);
        maze[x][y] = OLD_PATH_ACTIVE; // Mark your territory, king

        penguins += walk(x-1,y,maxDistance-1); // Let's gooo

        maze[x][y] = PLAYER; // Spawn
        draw(maze);
        maze[x][y] = OLD_PATH_ACTIVE; // Mark your territory, king

        penguins += walk(x,y+1,maxDistance-1); // Let's gooo

        maze[x][y] = PLAYER; // Spawn
        draw(maze);
        maze[x][y] = OLD_PATH_DONE; // Mark your territory, king

        penguins += walk(x,y-1,maxDistance-1); // Let's gooo

        return penguins; // -After all this time?! -Always
    }

}







/*
* public class Adamiani{
*      public static String nationality;
*        ----
*       private int age;
*
*       puv
*
*       public getNationality(){
*           return this.nationality;
*       }
* }
*
* Adamiani.nationality = "Qartveli";
*
* Adamiani Guga;
*
* write(Guga.getNationality()) // Qartveli
*  Guga.nationality = "Ukraineli";
*
*  Adamiani Giorgi;
*  write(Giorgi.nationality);
* */