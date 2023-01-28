package PenguinGameInAntarctica;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maze extends MiniJava {
    public static boolean draw = true;

    protected static final int NOTHING = -1;
    protected static final int LEFT = 1;
    protected static final int UP = 2;
    protected static final int RIGHT = 3;
    protected static final int DOWN = 4;

    private static JFrame frame = null;
    static Animal[][] antarktis;
    private static int wannaSleep = 100;
    private static boolean pause = false;
    private static Random r = new Random();
    protected static int currentEvent = NOTHING;


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
            GradientPaint gradient = new GradientPaint(0, 50, Color.WHITE, getWidth(), 0, Color.GRAY);
            ((Graphics2D) g).setPaint(gradient);


            g.fillRect(p.getLocation().x, p.getLocation().y, getWidth() * 2, getHeight());

            if (antarktis[x][y] != null) {
                antarktis[x][y].draw(g, getWidth(), getHeight());
            }
        }

        private void paintSymbol(Graphics g, Color c) {
            GradientPaint gradient = new GradientPaint(15, 0, c, getWidth(), 0, Color.LIGHT_GRAY);
            ((Graphics2D) g).setPaint(gradient);
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.fillOval((int) (getWidth() * 0.3), (int) (getHeight() * 0.3), (int) (getWidth() * 0.5),
                    (int) (getHeight() * 0.5));
        }

    }

    private static void setup(int height, int width) {

        JPanel content = new JPanel(new GridLayout(width, height));

        for (int y = 0; y < antarktis[0].length; y++)
            for (int x = 0; x < antarktis.length; x++) {
                content.add(new Field(x, y));
            }

        frame = new JFrame("A-Maze-Ing");
        frame.getContentPane().add(content);
        frame.setSize(400, 400 * (antarktis[0].length) / (antarktis.length));
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
                case KeyEvent.VK_LEFT:
                    currentEvent = LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                    currentEvent = RIGHT;
                    break;
                case KeyEvent.VK_UP:
                    currentEvent = UP;
                    break;
                case KeyEvent.VK_DOWN:
                    currentEvent = DOWN;
                    break;
                default:
                    break;
                }
            }
        });

        frame.setVisible(true);
    }

    public static void draw() {
        if (!draw || antarktis.length == 0)
            return;
        if (frame == null)
            setup(41, 41);

        try {
            while (pause)
                Thread.sleep(50);
            update();
            Thread.sleep(wannaSleep);
        } catch (InterruptedException ie) {
            /* Intentionally left blank */
        }
    }

    private static void update() {
        frame.repaint();
    }

    public static Animal[][] generateMaze(int width, int height) {
        Animal[][] maze = new Animal[width][height];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = null;
            }
        }

        return maze;
    }

    public static int[] getRandomEmptyField() {
        int x, y;
        do {
            x = r.nextInt(41);
            y = r.nextInt(41);
        } while (antarktis[x][y] != null);
        return new int[]{x, y};
    }

    public static void closeFrame() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
