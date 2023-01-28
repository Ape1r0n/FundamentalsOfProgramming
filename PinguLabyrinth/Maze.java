package PinguLabyrinth;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends MiniJava {
    public static boolean draw = true;

    public static final int FREE = 0;
    public static final int WALL = 1;
    public static final int PLAYER = 2;
    public static final int OLD_PATH_ACTIVE = 3;
    public static final int OLD_PATH_DONE = 4;
    public static final int PENGUIN = 5;

    private static final String filename = "tux.png";

    private static JFrame frame = null;
    private static int[][] maze;
    private static int wannaSleep = 100;
    private static boolean pause = false;

    private static Image peng;

    @SuppressWarnings("serial")
    private static class Field extends JPanel {
        Point p;
        int x, y;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
            p = getLocation();
        }

        public void paint(Graphics g) {
            super.paint(g);
            if (maze[x][y] == WALL) {
                GradientPaint gradient = new GradientPaint(10, 50, Color.GRAY, getWidth(), 0, Color.DARK_GRAY);
                ((Graphics2D) g).setPaint(gradient);
            } else {
                GradientPaint gradient = new GradientPaint(0, 50, Color.WHITE, getWidth(), 0, Color.GRAY);
                ((Graphics2D) g).setPaint(gradient);
            }

            g.fillRect(p.getLocation().x, p.getLocation().y, getWidth() * 2, getHeight());

            switch (maze[x][y]) {
                case PLAYER:
                    paintSymbol(g, Color.RED);
                    break;
                case OLD_PATH_ACTIVE:
                    paintSymbol(g, Color.BLUE);
                    break;
                case OLD_PATH_DONE:
                    paintSymbol(g, Color.GRAY);
                    break;
                case PENGUIN:
                    drawPeng(g);
                    break;
                default:
                    break;
            }
        }

        private void paintSymbol(Graphics g, Color c) {
            GradientPaint gradient = new GradientPaint(15, 0, c, getWidth(), 0, Color.LIGHT_GRAY);
            ((Graphics2D) g).setPaint(gradient);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.fillOval((int) (getWidth() * 0.3), (int) (getHeight() * 0.3), (int) (getWidth() * 0.5),
                    (int) (getHeight() * 0.5));
        }

        private void drawPeng(Graphics g) {
            if (peng == null) {
                paintSymbol(g, Color.YELLOW);
                return;
            }
            ((Graphics2D) g).drawImage(peng, 0, 0, getWidth(), getHeight(), 0, 0, peng.getWidth(null),
                    peng.getHeight(null), null);
        }
    }

    private static void setup(int[][] area) {
        maze = new int[area.length][area[0].length];

        File f = new File(filename);
        if (f.exists() && !f.isDirectory())
            peng = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());

        JPanel content = new JPanel(new GridLayout(area[0].length, area.length));

        for (int y = 0; y < maze[0].length; y++)
            for (int x = 0; x < maze.length; x++) {
                maze[x][y] = area[x][y];
                content.add(new Field(x, y));
            }

        frame = new JFrame("A-Maze-Ing");
        frame.getContentPane().add(content);
        frame.setSize(400, 400 * (maze[0].length) / (maze.length));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                frame.repaint();
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                switch (ke.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        frame.dispose();
                        System.exit(0);
                        break;
                    case KeyEvent.VK_PLUS:
                        wannaSleep = wannaSleep == 0 ? 0 : wannaSleep - 50;
                        System.out.println("delay=" + wannaSleep);
                        break;
                    case KeyEvent.VK_MINUS:
                        wannaSleep += 50;
                        System.out.println("delay=" + wannaSleep);
                        break;
                    case KeyEvent.VK_B:
                        System.out.println("break");
                        pause = true;
                        break;
                    case KeyEvent.VK_C:
                        System.out.println("continue");
                        pause = false;
                        break;
                    default:
                        break;
                }
            }
        });

        frame.setVisible(true);
    }

    public static void draw(int[][] maze) {
        if (!draw || maze.length == 0)
            return;
        if (frame == null)
            setup(maze);

        try {
            while (pause)
                Thread.sleep(50);
            update(maze);
            Thread.sleep(wannaSleep);
        } catch (InterruptedException ie) {
            /* Intentionally left blank */
        }
    }

    private static void update(int[][] area) {
        for (int x = 0; x < maze.length; x++)
            for (int y = 0; y < maze[0].length; y++)
                maze[x][y] = area[x][y];
        frame.repaint();
    }

    public static int[][] generateMaze(int width, int height) {
        return generateMaze(width, height, false, false, 0);
    }

    public static int[][] generatePenguinMaze(int width, int height) {
        return generateMaze(width, height, true, false, 0);
    }

    public static int[][] generateStandardMaze(int width, int height) {
        return generateMaze(width, height, false, true, 0);
    }

    public static int[][] generateStandardPenguinMaze(int width, int height) {
        return generateMaze(width, height, true, true, 0);
    }

    public static int[][] generateMaze(int width, int height, boolean penguins, boolean seeded, int seed) {
        width = Math.max(width, 3);
        height = Math.max(height, 3);

        int[][] maze = new int[width][height];

        // Borders:
        for (int i = 0; i < width; i++) {
            maze[i][0] = WALL;
            maze[i][height - 1] = WALL;
        }
        for (int i = 0; i < height; i++) {
            maze[0][i] = WALL;
            maze[width - 1][i] = WALL;
        }

        // Random obstacles:
        Random random = new Random();
        if (seeded) {
            random.setSeed(seed);
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (random.nextInt(4) == 0) {
                    maze[x][y] = WALL;
                }
            }
        }

        if (penguins) {
            // Random penguins:
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    if (random.nextInt(16) == 0) {
                        maze[x][y] = PENGUIN; // if(WALL != maze[x][y])
                    }
                }
            }
        } else {
            // Exit
            maze[width - 1][height - 2] = FREE;
            maze[width - 2][height - 2] = FREE;
        }
        // Entrance
        maze[1][0] = FREE;
        maze[1][1] = FREE;

        return maze;
    }
}