public class PinguArt extends MiniJava{
    public static void main(String[] args) {
        int a, b, c, d, e, f, g, h, k = 8;
        a = readInt("Please enter a Pingu Art number: ");
        b = readInt("Please enter a Pingu Art number: ");
        c = readInt("Please enter a Pingu Art number: ");
        d = readInt("Please enter a Pingu Art number: ");
        e = readInt("Please enter a Pingu Art number: ");
        f = readInt("Please enter a Pingu Art number: ");
        g = readInt("Please enter a Pingu Art number: ");
        h = readInt("Please enter a Pingu Art number: ");

        write("+---[PinguArt]---+");

        writeConsole("|");

        while (k != 0){
            int n1 = a%10;
            if (n1 == 2) {
                writeConsole("~");
            } else if (n1 == 1) {
                writeConsole("-");
            } else if (n1 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            a = (a - a%10)/10;
            k--;
        }
        k = 8;

        while (k != 0){
            int n2 = b%10;
            if (n2 == 2) {
                writeConsole("~");
            } else if (n2 == 1) {
                writeConsole("-");
            } else if (n2 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            b = (b - b%10)/10;
            k--;
        }
        k = 8;

        write("|");
        writeConsole("|");

        while (k != 0){
            int n3 = c%10;
            if (n3 == 2) {
                writeConsole("~");
            } else if (n3 == 1) {
                writeConsole("-");
            } else if (n3 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            c = (c - c%10)/10;
            k--;
        }
        k = 8;

        while (k != 0){
            int n4 = d%10;
            if (n4 == 2) {
                writeConsole("~");
            } else if (n4 == 1) {
                writeConsole("-");
            } else if (n4 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            d = (d - d%10)/10;
            k--;
        }
        k = 8;

        write("|");
        writeConsole("|");

        while (k != 0){
            int n5 = e%10;
            if (n5 == 2) {
                writeConsole("~");
            } else if (n5 == 1) {
                writeConsole("-");
            } else if (n5 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            e = (e - e%10)/10;
            k--;
        }
        k = 8;

        while (k != 0){
            int n6 = f%10;
            if (n6 == 2) {
                writeConsole("~");
            } else if (n6 == 1) {
                writeConsole("-");
            } else if (n6 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            f = (f - f%10)/10;
            k--;
        }
        k = 8;

        write("|");
        writeConsole("|");

        while (k != 0){
            int n7 = g%10;
            if (n7 == 2) {
                writeConsole("~");
            } else if (n7 == 1) {
                writeConsole("-");
            } else if (n7 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            g = (g - g%10)/10;
            k--;
        }
        k = 8;

        while (k != 0){
            int n8 = h%10;
            if (n8 == 2) {
                writeConsole("~");
            } else if (n8 == 1) {
                writeConsole("-");
            } else if (n8 == 3) {
                writeConsole("P");
            } else {
                writeConsole(" ");
            }
            h = (h - h%10)/10;
            k--;
        }
        k = 8;

        write("|");

        write("+----------------+");
    }
}
