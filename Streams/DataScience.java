package Streams;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataScience {
  public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) {
    return stream.collect(Collectors.groupingBy(PenguinData::getTrackID)).entrySet().stream().map(entry -> new Penguin(entry.getValue().stream().map(PenguinData::getGeom).collect(Collectors.toList()),entry.getKey()));
  }

  public static void outputPenguinStream() {
      System.out.println(getDataByTrackId(CSVReading.processInputFile()).count());
      getDataByTrackId(CSVReading.processInputFile()).sorted(Comparator.comparing(Penguin::getTrackID)).toList().forEach(o -> System.out.println(o.toStringUsingStreams()));
  }

  public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) {
      getDataByTrackId(stream).toList().stream().forEach(p ->{
          double minLatitude = p.getLocations().stream().mapToDouble(Geo::getLatitude).min().getAsDouble();
          double maxLatitude = p.getLocations().stream().mapToDouble(Geo::getLatitude).max().getAsDouble();
          double avgLatitude = p.getLocations().stream().mapToDouble(Geo::getLatitude).average().getAsDouble();
          double minLongitude = p.getLocations().stream().mapToDouble(Geo::getLongitude).min().getAsDouble();
          double maxLongitude = p.getLocations().stream().mapToDouble(Geo::getLongitude).max().getAsDouble();
          double avgLongitude = p.getLocations().stream().mapToDouble(Geo::getLongitude).average().getAsDouble();

          System.out.println(p.getTrackID());
          System.out.println("Min Longitude: " + minLongitude + " Max Longitude: " + maxLongitude + " Avg Longitude: " + avgLongitude + " Min Latitude: " + minLatitude + " Max Latitude: " + maxLatitude + " Avg Latitude: " + avgLatitude);
      });
  }

  public static void main(String[] args) {
    // TODO Test your implementation yourself
    //CSVReading.processInputFile().forEach(x -> System.out.println(x.toString()));
    outputPenguinStream();
  }
}
