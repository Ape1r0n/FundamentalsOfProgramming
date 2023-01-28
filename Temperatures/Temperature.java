package Temperatures;

import java.time.LocalDate;

public class Temperature {
    private final LocalDate date;
    private final double temperature;
    private final String city;
    private final String country;
    private final double latitude;
    private final double longitude;

    public Temperature(LocalDate date, double averageTemperature, String city,
                       String country, double latitude, double longitude) {
        this.date = date;
        this.temperature = averageTemperature;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}