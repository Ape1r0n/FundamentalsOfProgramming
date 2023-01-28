package PenguinGameInAntarctica;

import java.awt.event.WindowEvent;

public class Antarktis extends Maze {
    private static int width, height;
    private static Penguin lostPenguin;
    private static Whale[] whales = new Whale[5];
    private static LeopardSeal[] leopardSeals = new LeopardSeal[20];
    private static Fish[] fishes = new Fish[500];
    private static PlayerPenguin playerPenguin;

    public static void main(String[] args) {
        width = 41;
        height = 41;
        antarktis = generateMaze(width, height);
        Animal.setAntarktis(antarktis);
        setupMaze();
        gameLoop();
        // Close the opened frame
        closeFrame();
    }

    private static void gameLoop() {
        while (true) {
            draw();
            moveAll();
            currentEvent = NOTHING;
            if(playerMove) break;
        }
    }

    public static boolean playerMove = false;

    private static void moveAll() {
        switch(currentEvent){
            case LEFT -> playerMove = playerPenguin.move(playerPenguin.x - 1, playerPenguin.y);
            case RIGHT -> playerMove = playerPenguin.move(playerPenguin.x + 1, playerPenguin.y);
            case UP -> playerMove = playerPenguin.move(playerPenguin.x, playerPenguin.y - 1);
            case DOWN -> playerMove = playerPenguin.move(playerPenguin.x, playerPenguin.y + 1);
        }

        for(int i = 0; i < whales.length; i++){
            if(!whales[i].isTroop()) whales[i].move();
        }

        for(int i = 0; i < leopardSeals.length; i++){
            if(!leopardSeals[i].isTroop()) leopardSeals[i].move();
        }

        for(int i = 0; i < fishes.length; i++){
            if(!fishes[i].isTroop()) fishes[i].move();
        }

        if(playerPenguin.isTroop()){
            if(antarktis[playerPenguin.x][playerPenguin.y].isWhale()){
                System.out.println("Defeat!");
                playerMove = true;
            }
        }

        lostPenguin.move();

    }

    /**
     * Example Setup for easier Testing during development
     */
    private static void setupMaze() {
        int[] pos;
        playerPenguin = new PlayerPenguin(3, 3);
        antarktis[3][3] = playerPenguin;

        for (int i = 0; i < whales.length; i++) {
            pos = getRandomEmptyField();
            whales[i] = new Whale(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = whales[i];
        }

        for (int i = 0; i < leopardSeals.length; i++) {
            pos = getRandomEmptyField();
            leopardSeals[i] = new LeopardSeal(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = leopardSeals[i];
        }

        for (int i = 0; i < fishes.length; i++) {
            pos = getRandomEmptyField();
            fishes[i] = new Fish(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = fishes[i];
        }

        antarktis[20][20] = new Penguin(20, 20);
        lostPenguin = (Penguin) antarktis[20][20];
    }
}
