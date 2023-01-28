package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class CSVReading {

  private static List<PenguinData> instance = null;
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

  public static Stream<PenguinData> processInputFile() {
      //TODO
    try {
      Stream<String> lines = Files.lines(Paths.get("/home/apeiron/IdeaProjects/trial/src/OC_LPhillips_LittlePenguin_GPS_tracks_DATA.csv"));
      return lines.skip(1).map(mapToPenguinData);
    } catch (IOException e) {
      System.out.println("Data Path seems to be wrong");
      return Stream.empty();
    }
  }


  private static Function<String, PenguinData> mapToPenguinData = (line) -> {
    String[] p = line.split(","); // a CSV has comma separated lines
    LocalDateTime dateTime = LocalDateTime.parse(p[2], formatter);
    return new PenguinData(p[0], Integer.parseInt(p[1]), dateTime, Double.parseDouble(p[3]),
        Double.parseDouble(p[4]), p[5], p[6], p[7], new Geo(p[8]));
  };
}
