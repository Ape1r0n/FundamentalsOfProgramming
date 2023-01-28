package TelephoneBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Random;

/**
 * This class provides convenience methods to make the barrier of entry into
 * programming easier. In addition to that it realizes an educational
 * sub-language to Java called "Mini Java" with simpler grammar.
 */
public class MiniJava {
    private static Random rand;
    private static InputStream is = System.in;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

    /**
     * Reads a {@link String} from the console, and prompts the user by printing the
     * given <code>text</code> with a line break to the console.
     * @param text the text to display on the console before reading an input.
     * @return the input string or <code>null</code>, if no input is available
     *         (should normally not happen)
     */
    public static String readString(String text) {
        // Exchange the reader in case System.in has changed.
        // This is necessary for testing, as for every test input, System.in is changed.
        // TODO: Consider whether a better solution is possible with mocking/a different
        // InputStream implementation
        // on the test side.
        if (System.in != is) {
            is = System.in;
            bufferedReader = new BufferedReader(new InputStreamReader(is));
        }
        try {
            System.out.println(text);
            return bufferedReader.readLine();
        } catch (IOException e) {
            // We "hide" the exception in the method signature by rethrowing an unchecked
            // exception
            throw new UncheckedIOException("Input could not be parsed.", e);
        }
    }

    /**
     * Reads a {@link String} from the console, and prompts the user by printing the
     * line
     *
     * <pre>
     * Input:
     * </pre>
     */
    public static String readString() {
        return readString("Input:");
    }

    /**
     * Tries to read an <code>int</code> from the console, and retires if the input
     * was not a valid integer. It prompts the user by printing the given
     * <code>text</code> with a line break to the console.
     *
     * @see Integer#parseInt(String)
     */
    public static int readInt(String text) {
        Integer x = null;
        do {
            String s = readString(text);
            if (s == null)
                throw new IllegalStateException("No (further) input available.");
            try {
                x = Integer.parseInt(s.trim());
            } catch (@SuppressWarnings("unused") NumberFormatException e) {
                // try again
            }
        } while (x == null);
        return x;
    }

    /**
     * Works like {@link #readInt(String)}, but uses the following preset text to
     * prompt the user:
     *
     * <pre>
     * Please enter an integer:
     * </pre>
     */
    public static int readInt() {
        return readInt("Please insert an integer:");
    }

    /**
     * Identical to {@link #readInt(String)}.
     */
    public static int read(String text) {
        return readInt(text);
    }

    /**
     * Identical to {@link #readInt()}.
     * <p>
     * <i>Identisch zu {@link #readInt()}</i>
     */
    public static int read() {
        return readInt();
    }

    /**
     * Tries to read an <code>double</code> from the console, and retires if the
     * input was not a valid double value. It prompts the user by printing the given
     * <code>text</code> with a line break to the console.
     *
     * @see Double#parseDouble(String)
     */
    public static double readDouble(String text) {
        Double x = null;
        do {
            String s = readString(text);
            if (s == null)
                throw new IllegalStateException("No (further) input available.");
            try {
                x = Double.parseDouble(s.trim());
            } catch (@SuppressWarnings("unused") NumberFormatException e) {
                // try again
            }
        } while (x == null);
        return x;
    }

    /**
     * Works like {@link #readDouble(String)}, but uses the following preset text to
     * prompt the user:
     *
     * <pre>
     * Please insert a number:
     * </pre>
     */
    public static double readDouble() {
        return readDouble("Please insert a number:");
    }

    /**
     * Prints the {@link String} to the console and breaks the line.
     */
    public static void write(String output) {
        System.out.println(output);
    }

    /**
     * Prints the <code>int</code> to the console and breaks the line.
     */
    public static void write(int output) {
        write("" + output);
    }

    /**
     * Prints the <code>double</code> to the console and breaks the line.
     */
    public static void write(double output) {
        write("" + output);
    }

    /**
     * Identical to {@link #write(String)}.
     */
    public static void writeLineConsole(String output) {
        System.out.println(output);
    }

    /**
     * Identical to {@link #write(int)}.
     */
    public static void writeLineConsole(int output) {
        writeLineConsole("" + output);
    }

    /**
     * Identical to {@link #write(double)}.
     */
    public static void writeLineConsole(double output) {
        writeLineConsole("" + output);
    }

    /**
     * Prints a line separator in the console.
     */
    public static void writeLineConsole() {
        writeLineConsole("");
    }

    /**
     * Prints the {@link String} to the console. Does not end with a line break.
     */
    public static void writeConsole(String output) {
        System.out.print(output);
    }

    /**
     * Prints the <code>int</code> to the console. Does not end with a line break.
     */
    public static void writeConsole(int output) {
        writeConsole("" + output);
    }

    /**
     * Prints the <code>double</code> to the console. Does not end with a line
     * break.
     */
    public static void writeConsole(double output) {
        writeConsole("" + output);
    }

    public static void resetRandom() {
        rand = null;
    }

    public static void setRandomWithSeed(int seed) throws IllegalAccessException {
        if (rand != null) {
            throw new IllegalAccessException("Don't touch this");
        }
        rand = new Random(seed);
    }

    public static void setRandom() throws IllegalAccessException {
        setRandomWithSeed(144);
    }

    public static int randomInt(int minval, int maxval) {
        return minval + rand.nextInt(maxval - minval + 1);
    }

    /**
     * Draws a random card, represented by its value. The value ranges from 1
     * (inclusive) to 105 (inclusive).
     * @throws IllegalAccessException
     */
    public static int drawCard() throws IllegalAccessException {
        if (rand == null) {
            setRandom();
        }
        return randomInt(1, 105);
    }

    /**
     * Returns a random integer between 1 (inclusive) to 6 (inclusive).
     * @throws IllegalAccessException
     */
    public static int dice() throws IllegalAccessException {
        if (rand == null) {
            setRandom();
        }
        return randomInt(1, 6);
    }
}