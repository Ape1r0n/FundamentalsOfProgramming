package Streams;

import java.time.LocalDateTime;

public class PenguinData {
  public String fid;
  public int id;
  public LocalDateTime datetime;
  public double latitude;
  public double longitude;
  public String site;
  public String penguinTrack;
  public String trackID;
  public Geo geom;

  public PenguinData(String fid, int id, LocalDateTime datetime, double latitude, double longitude,
      String site, String penguinTrack, String trackID, Geo geom) {
    this.fid = fid;
    this.id = id;
    this.datetime = datetime;
    this.latitude = latitude;
    this.longitude = longitude;
    this.site = site;
    this.penguinTrack = penguinTrack;
    this.trackID = trackID;
    this.geom = geom;
  }

  public String getFid() {
    return fid;
  }

  public int getId() {
    return id;
  }

  public LocalDateTime getDatetime() {
    return datetime;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public String getSite() {
    return site;
  }

  public String getPenguinTrack() {
    return penguinTrack;
  }

  public String getTrackID() {
    return trackID;
  }

  public Geo getGeom() {
    return geom;
  }

  @Override
  public String toString() {
    return "PenguinData{" +
        "fid='" + fid + '\'' +
        ", id=" + id +
        ", datetime=" + datetime +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        ", site='" + site + '\'' +
        ", penguinTrack='" + penguinTrack + '\'' +
        ", trackID='" + trackID + '\'' +
        ", geom=" + geom +
        '}';
  }
}
