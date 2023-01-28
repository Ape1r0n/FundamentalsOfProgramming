package Temperatures;

import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTemperatures extends Temperatures {
    public StreamTemperatures(String filepath) {
        super(filepath);
    }

    public long size() {
        return stream().count();
    }

    public List<LocalDate> dates() {
        return stream().map(Temperature::getDate).distinct().sorted().collect(Collectors.toList());
    }

    public Set<String> cities() {
        return stream().map(Temperature::getCity).collect(Collectors.toSet());
    }

    public Set<String> countries() {
        return stream().map(Temperature::getCountry).collect(Collectors.toSet());
    }

    public Map<String, List<Double>> temperaturesByCountry(){
        Map<String, List<Double>> result = new HashMap<>();
        countries().stream().forEach(p -> result.put(p, new ArrayList<>()));
        stream().forEach(temp -> result.get(temp.getCountry()).add(temp.getTemperature()));
        return result;
    }

    @Override
    public String coldestCountryAbs() {
        return stream().min(Comparator.comparing(Temperature::getTemperature)).get().getCountry();
    }

    @Override
    public String hottestCountryAbs() {
        return stream().max(Comparator.comparing(Temperature::getTemperature)).get().getCountry();
    }

    @Override
    public Map<String, Double> countriesAvgTemperature() {
        Map<String, Double> result = new HashMap<>();
        temperaturesByCountry().entrySet().stream().forEach(e -> result.put(e.getKey(), e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));
        return result;
    }

    public Map<String, Double> avgTemperatureDeltaPerYearPerCountry() {

        return null;
    }

    public static void main(final String[] args) {
        String filepath = "temperatureCSV.csv";
        StreamTemperatures temperatures = new StreamTemperatures(filepath);

        temperatures.printSummary();
        final Map<String, Double> values = temperatures
                .avgTemperatureDeltaPerYearPerCountry();

        print("Averaged yearly temperature delta per country:",
                Arrays.toString(values.entrySet().toArray()));
    }

}