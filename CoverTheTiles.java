public class CoverTheTiles extends MiniJava {
    // Output of open tiles. Don't modify this
    public static void outputTiles(boolean[] tiles) {
        StringBuilder sb = new StringBuilder("Open tiles: 1:");
        sb.append(tiles[0]);
        for (int i = 1; i < tiles.length; i++) {
            sb.append(" ").append(i + 1).append(":").append(tiles[i]);
        }
        write(sb.toString());
    }

    public static void main(String[] args) throws IllegalAccessException {
        int p1_acc = 0, p2_acc = 0, p1_r1, p1_r2, p2_r1, p2_r2, p1_1, p1_2, p2_1, p2_2;
        boolean[] tiles = {true, true, true, true, true, true, true, true, true, true};

        for (int i = 0; i < tiles.length; i++) {
            write("Player 1 numbers:");
            p1_r1 = dice();
            p1_r2 = dice();
            write(p1_r1);
            write(p1_r2);
            outputTiles(tiles);
            write("Which tiles to cover by player 1? (0 for no valid combination)");
            p1_1 = readInt("Tile 1:");
            p1_2 = readInt("Tile 2:");
            if (p1_1 == 0 || p1_2 == 0) {
                for (int j = 0; j < 10; j++) {
                    if (tiles[j] == true) {
                        p1_acc += (j + 1);
                    }
                }
            } else {
                if ((p1_1 + p1_2 == p1_r1 + p1_r2) && (p1_1 != p1_2) && (tiles[p1_1 - 1] == true && tiles[p1_2 - 1] == true)) {
                    tiles[p1_1 - 1] = false;
                    tiles[p1_2 - 1] = false;
                } else {
                    while((p1_1 + p1_2 != p1_r1 + p1_r2) || (p1_1 < 0 || p1_1 > 10) || (p1_1 == p1_2) || (tiles[p1_1 - 1] == false || tiles[p1_2 - 1] == false)) {
                        write("Player 1 numbers:");
                        write(p1_r1);
                        write(p1_r2);
                        outputTiles(tiles);
                        write("Which tiles to cover by player 1? (0 for no valid combination)");
                        p1_1 = readInt("Tile 1:");
                        p1_2 = readInt("Tile 2:");
                        if (p1_1 == 0 || p1_2 == 0) {
                            for (int j = 0; j < 10; j++) {
                                if (tiles[j] == true) {
                                    p1_acc += (j + 1);
                                }

                            }
                            break;
                        } else if (tiles[p1_1 - 1] == true && tiles[p1_2 - 1] == true) {
                            tiles[p1_1 - 1] = false;
                            tiles[p1_2 - 1] = false;
                        }
                    }
                }
            }

            int c1 = 0;
            for (int l = 0; l < tiles.length; l++) {
                if (tiles[l] == false) {
                    c1++;
                }
            }
            if (c1 == 10) {
                write("Player 1 wins!");
                break;
            }

            write("Player 2 numbers:");
            p2_r1 = dice();
            p2_r2 = dice();
            write(p2_r1);
            write(p2_r2);
            outputTiles(tiles);
            write("Which tiles to cover by player 2? (0 for no valid combination)");
            p2_1 = readInt("Tile 1:");
            p2_2 = readInt("Tile 2:");
            if (p2_1 == 0 || p2_2 == 0) {
                for (int j = 0; j < 10; j++) {
                    if (tiles[j] == true) {
                        p2_acc += (j + 1);
                    }
                }
                break;
            } else {
                if ((p2_1 + p2_2 == p2_r1 + p2_r2) && (p2_1 != p2_2) && (tiles[p2_1 - 1] == true && tiles[p2_2 - 1] == true)) {
                    tiles[p2_1 - 1] = false;
                    tiles[p2_2 - 1] = false;
                } else {
                    while ((p2_1 + p2_2 != p2_r1 + p2_r2) || (p2_1 == p2_2) || (p2_1 < 0 || p2_1 > 10) || (tiles[p2_1 - 1] == false || tiles[p2_2 - 1] == false)) {
                        write("Player 2 numbers:");
                        write(p2_r1);
                        write(p2_r2);
                        outputTiles(tiles);
                        write("Which tiles to cover by player 2? (0 for no valid combination)");
                        p2_1 = readInt("Tile 1:");
                        p2_2 = readInt("Tile 2:");
                        tiles[p2_1 - 1] = false;
                        tiles[p2_2 - 1] = false;
                    }
                }
            }

            int c2 = 0;
            for (int l = 0; l < tiles.length; l++) {
                if (tiles[l] == false) {
                    c2++;
                }
            }
            if (c2 == 10) {
                write("Player 2 wins!");
                break;
            }
            if(i == 9){
                if (p1_acc < p2_acc)
                    write("Player 1 wins!");
                else if (p2_acc < p1_acc)
                    write("Player 2 wins!");
                else
                    write("draw!");
            }
        }
    }
}