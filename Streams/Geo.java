package Streams;

public class Geo {
  public double latitude;
  public double longitude;

  public Geo(String geom) {
    geom = geom.substring(7);
    String[] strings = geom.split(" ");
    this.longitude = Double.parseDouble(strings[0]);
    this.latitude = Double.parseDouble(strings[1].substring(0, strings[1].length() - 1));
  }

  public Geo(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    return "Geo{" +
        "latitude=" + latitude +
        ", longitude=" + longitude +
        '}';
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }
}
