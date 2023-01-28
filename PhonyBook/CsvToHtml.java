package PhonyBook;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

public class CsvToHtml{

    private Function<String[], CsvEntry> cellsToEntry;

    public CsvToHtml(Function<String[], CsvEntry> cellsToEntry) {
        this.cellsToEntry = cellsToEntry;
    }


    private static String[] splitLine(String line){
        ArrayList<String> cells = new ArrayList<>();
        int counter = 0;
        boolean citataa = false;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ',' && !citataa){
                sb.append(line.substring(counter, i));
                cells.add(sb.toString());
                sb.delete(0, sb.length());
                counter = i + 1;
            }else if (line.charAt(i) == '"'){
                if(citataa){
                    if(i+1 < line.length() && line.charAt(i+1) == '"') i++;
                    else{
                        if(i+1 < line.length() && line.charAt(i+1) != ',') return null;
                        citataa = false;
                    }
                    sb.append(line.substring(counter, i));
                    counter = i + 1;
                }else{
                    if (sb.length() != 0) return null;
                    citataa = true;
                    counter = i+1;
                }
            }
        }

        sb.append(line.substring(counter, line.length()));
        cells.add(sb.toString());
        return cells.toArray(String[]::new);
    }



    public void convert(Path in, Path out) {
        if (!Files.isRegularFile(in)) {
            System.out.println("We come in peace broo");
            return;
        }

        if (Files.exists(out)) {
            System.out.println("Output path exists");
            return;
        }

        try {
            Files.createFile(out);
        } catch (IOException e) {
            System.out.println("Output file creation error");
        }

        try {
            Files.writeString(out, "<html><body><table>\n", StandardOpenOption.APPEND);
            Files.lines(in).map(CsvToHtml::splitLine).filter(Objects::nonNull).map(cellsToEntry).filter(Objects::nonNull).map(CsvEntry::toHtml).forEach(i -> {
                        try {
                            Files.writeString(out, i + "\n",
                                    StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            System.out.println("IOException: smth");
                        }});

            Files.writeString(out, "</table></body></html>\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("could not read/write!");
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Input should be 3 arguments long");
            return;
        }

        CsvToHtml smth = new CsvToHtml(PhoneBookEntry::cellsToEntry);
        smth.convert(Paths.get(args[0]), Paths.get(args[1]));
    }
}