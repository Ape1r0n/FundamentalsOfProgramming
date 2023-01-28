package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Penguin {
  private List<Geo> locations;
  private String trackID;

  public Penguin(List<Geo> locations, String trackID) {
    this.locations = locations;
    this.trackID = trackID;
  }

  @Override
  public String toString() {
    return "Penguin{" +
        "locations=" + locations +
        ", trackID='" + trackID + '\'' +
        '}';
  }

  public List<Geo> getLocations() {
    return locations;
  }

  public String getTrackID() {
    return trackID;
  }

  private int diff(double a, double b){
    return (a == b) ? 0 : ((b - a > 0)? 1: -1);
  }

  public String toStringUsingStreams() {
    return "Penguin{locations=" + locations.stream().sorted((x,y) -> { return (y.getLatitude() - x.getLatitude() != 0) ? diff(x.getLatitude(), y.getLatitude()) : diff(x.getLongitude(), y.getLongitude());}).toList().toString() + ", trackID=" + "\'" + trackID + "\'" + "}";
  }
}
