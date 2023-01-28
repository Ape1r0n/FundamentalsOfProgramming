package Temperatures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Temperatures {
    protected List<Temperature> data;

    public Temperatures(String filepath) {
        data = parseCsvFile(new File(filepath));
    }

    public Stream<Temperature> stream() {
        return data.stream();
    }

    public void printSummary() {
        print("Number of temperature datapoints:", size());
        print("Cities:", cities());
        print("Countries:", countries());
        print("Coldest Country (absolute Temperature):", coldestCountryAbs());
        print("Hottest Country (absolute Temperature):", hottestCountryAbs());
        print("Countries' average temperature:", countriesAvgTemperature());
    }

    protected static void print(final Object... objects) {
        final String msg = Arrays
                .stream(objects)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(msg);
    }

    static private List<Temperature> parseCsvFile(final File csvFile) {
        try {
            return Files.lines(csvFile.toPath()).skip(1) // skip header of csv file
                    .map(lineToTemperature) // convert line to DateTemperature
                    .filter(elem -> elem != null) // filter null values due to parsing errors
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("File " + csvFile + " not found.");
        }
    }

    static private Function<String, Temperature> lineToTemperature = (line) -> {
        try {
            final String[] fields = line.split(","); // a CSV with comma-separated lines
            final LocalDate date = LocalDate.parse(fields[0]);
            final double avgTemperature = Double.parseDouble(fields[1]);
            // Skipping uncertainty
            final String city = fields[3];
            final String country = fields[4];
            final double latitude = Double.parseDouble(fields[5].substring(0, fields[5].length() - 1));
            final double longitude = Double.parseDouble(fields[6].substring(0, fields[6].length() - 1));
            return new Temperature(date, avgTemperature, city, country, latitude, longitude);
        } catch (Exception e) {
            return null;
        }
    };

    public abstract long size();

    public abstract List<LocalDate> dates();

    public abstract Set<String> cities();

    public abstract Set<String> countries();

    public abstract Map<String, List<Double>> temperaturesByCountry();

    public abstract Map<String, Double> countriesAvgTemperature();

    public abstract String coldestCountryAbs();

    public abstract String hottestCountryAbs();
}
