
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class MiniJava {
  private static InputStream is = System.in;
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

  public static String readString(String text) {
    // Exchange the reader in case System.in has changed.
    // This is necessary for testing, as for every test input, System.in is changed.
    if (System.in != is) {
      is = System.in;
      bufferedReader = new BufferedReader(new InputStreamReader(is));
    }
    try{
        System.out.println(text);
        return bufferedReader.readLine();
    } catch (IOException e) {
        throw new RuntimeException("Could not read input.");
    }
  }
  public static String readString() {
    return readString("Input:");
  }

  public static int readInt(String text) {
    String s = readString(text);

    int x;
    if (s == null)
      System.exit(0);
    try {
      x = Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      x = readInt(text);
    }
    return x;
  }

  public static int readInt() {
    return readInt("Please insert an integer:");
  }

  public static int read(String text) {
    return readInt(text);
  }

  public static int read() {
    return readInt();
  }

  public static double readDouble(String text) {
    String s = readString(text);

    double x;
    if (s == null)
      System.exit(0);
    try {
      x = Double.parseDouble(s.trim());
    } catch (NumberFormatException e) {
      x = readDouble(text);
    }
    return x;
  }
 public static double readDouble() {
    return readDouble("Please insert a FP number:");
  }

  public static void write(String output) {
    System.out.println(output);
  }

  public static void write(int output) {
    write("" + output);
  }

  public static void write(double output) {
    write("" + output);
  }

  public static void writeLineConsole(String output) {
    System.out.println(output);
  }

  public static void writeLineConsole(int output) {
    writeLineConsole("" + output);
  }

 public static void writeLineConsole(double output) {
    writeLineConsole("" + output);
  }

  public static void writeLineConsole() {
    writeLineConsole("");
  }

  public static void writeConsole(String output) {
    System.out.print(output);
  }

  public static void writeConsole(int output) {
    writeConsole("" + output);
  }

  public static void writeConsole(double output) {
    writeConsole("" + output);
  }

  public static int randomInt(int minval, int maxval) {
    return minval + (new java.util.Random()).nextInt(maxval - minval + 1);
  }
 public static int drawCard() {
    return randomInt(2, 11);
  }

  public static int dice() {
    return randomInt(1, 6);
  }
}
