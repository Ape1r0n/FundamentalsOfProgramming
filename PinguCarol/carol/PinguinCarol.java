package PinguCarol.carol;

import static PinguCarol.MiniJava.*;

public class PinguinCarol {
    public static void main(String[] args) {
        int width = readInt("Enter the playing field width:"), height = readInt("Enter pitch height:");
        if(width <  1 || height < 1){
            write("The width and height of the playing field must be greater than zero.");
        }else {
            int[][] array = new int[width][height];
            for(int i=0; i<width; i++){
                for(int j=0; j<width; j++){
                    array[i][j] = randomInt(-1,9);
                }
            }
            printPlayground(array);
            int st_x = readInt("Starting position x:"), st_y = readInt("Starting position y:"), st_d = readInt("Direction of view at the beginning:"), st_ib = readInt("Ice blocks at the beginning:");
            if(st_x < 0 || st_x >= width || st_y < 0 || st_y >= height || st_d < 0 || st_d > 3 || st_ib < 0 || st_ib > 10){
                write("Invalid start values.");
            }else{
                char c = ' ';
                while(c != 'e'){
                    c = readChar("Enter instruction:");
                    if(c != 'a' && c != 'r' && c != 'l'  && c != 'n' && c != 'p' && c != 's' && c != 'e'){
                        write("Unknown instruction!");
                    }else {
                        switch (c) {
                            case 'a':
                                printPlayground(array, st_x, st_y, st_d, st_ib);
                                break;
                            case 'r':
                                if (st_d != 0) {
                                    st_d--;
                                } else {
                                    st_d = 3;
                                }
                                break;
                            case 'l':
                                if (st_d != 3) {
                                    st_d++;
                                } else {
                                    st_d = 0;
                                }
                                break;
                            case 's':
                                switch (st_d) {
                                    case 0:
                                        if (st_x == width - 1) {
                                            write("Carol cannot leave the field.");
                                        } else if ((array[st_x][st_y] + 1) < array[st_x + 1][st_y] || (array[st_x][st_y] - 1) > array[st_x + 1][st_y]) {
                                            write("Carol cannot go to the next field because the difference in height is too great.");
                                        } else {
                                            ++st_x;
                                        }
                                        break;
                                    case 1:
                                        if (st_y == height - 1) {
                                            write("Carol cannot leave the field.");
                                        } else if ((array[st_x][st_y] + 1) < array[st_x][st_y + 1] || (array[st_x][st_y] - 1) > array[st_x][st_y + 1]) {
                                            write("Carol cannot go to the next field because the difference in height is too great.");
                                        } else {
                                            ++st_y;
                                        }
                                        break;
                                    case 2:
                                        if (st_x == 0) {
                                            write("Carol cannot leave the field.");
                                        } else if ((array[st_x][st_y] + 1) < array[st_x - 1][st_y] || (array[st_x][st_y] - 1) > array[st_x - 1][st_y]) {
                                            write("Carol cannot go to the next field because the difference in height is too great.");
                                        } else {
                                            --st_x;
                                        }
                                        break;
                                    case 3:
                                        if (st_y == 0) {
                                            write("Carol cannot leave the field.");
                                        } else if ((array[st_x][st_y] + 1) < array[st_x][st_y - 1] || (array[st_x][st_y] - 1) > array[st_x][st_y - 1]) {
                                            write("Carol cannot go to the next field because the difference in height is too great.");
                                        } else {
                                            --st_y;
                                        }
                                        break;
                                }
                                break;
                            case 'n':
                                if (st_ib == 10) {
                                    write("Carol can't take a block of ice, she's already carrying ten.");
                                } else if (array[st_x][st_y] == -1) {
                                    write("Carol cannot take blocks of ice in the water.");
                                } else if ((st_d == 0 && st_x == width-1) || (st_d == 1 && st_y == height-1) || (st_d == 2 && st_x == 0) || (st_d == 3 && st_y == 0)) {
                                    write("Carol cannot take blocks of ice off the field.");
                                } else if ((st_d == 0 && array[st_x + 1][st_y] == -1) || (st_d == 1 && array[st_x][st_y + 1] == -1) || (st_d == 2 && array[st_x - 1][st_y] == -1) || (st_d == 3 && array[st_x][st_y - 1] == -1)) {
                                    write("Carol can't take a block of ice, there aren't any left.");
                                } else {
                                    st_ib++;
                                    if (st_d == 0) {
                                        array[st_x + 1][st_y] -= 1;
                                    } else if (st_d == 1) {
                                        array[st_x][st_y + 1] -= 1;
                                    } else if (st_d == 2) {
                                        array[st_x - 1][st_y] -= 1;
                                    } else {
                                        array[st_x][st_y - 1] -= 1;
                                    }
                                }
                                break;
                            case 'p':
                                if (st_ib == 0) {
                                    write("Carol can't lay a block of ice because she isn't carrying one.");
                                } else if (array[st_x][st_y] == -1) {
                                    write("Carol cannot lay blocks of ice in the water.");
                                } else if ((st_d == 0 && (st_x + 1) == width) || (st_d == 1 && (st_y + 1) == height) || (st_d == 2 && st_x == 0) || (st_d == 3 && st_y == 0)) {
                                    write("Carol cannot put blocks of ice off the field of play.");
                                } else if ((st_d == 0 && array[st_x + 1][st_y] == 9) || (st_d == 1 && array[st_x][st_y + 1] == 9) || (st_d == 2 && array[st_x - 1][st_y] == 9) || (st_d == 3 && array[st_x][st_y - 1] == 9)) {
                                    write("Carol can't lay a block of ice, there are already ten blocks of ice on the field.");
                                } else {
                                    st_ib--;
                                    if (st_d == 0) {
                                        array[st_x + 1][st_y] += 1;
                                    } else if (st_d == 1) {
                                        array[st_x][st_y + 1] += 1;
                                    } else if (st_d == 2) {
                                        array[st_x - 1][st_y] += 1;
                                    } else {
                                        array[st_x][st_y - 1] += 1;
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
    }
}