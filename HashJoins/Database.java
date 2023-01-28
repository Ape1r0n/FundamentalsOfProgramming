package HashJoins;

// TODO Import the stuff you need

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.time.LocalDate;

public class Database {
    private static Path baseDataDirectory = Paths.get("/home/apeiron/IdeaProjects/trial/data");
    private Map<Integer, String> custKeyMapping;
    private Map<Integer, String> orderKeyMapping;
    public static void setBaseDataDirectory(Path baseDataDirectory) {
        Database.baseDataDirectory = baseDataDirectory;
    }

    private static Function<String, Customer> mapToCustomer = (line) -> {
        String[] strArr = line.split("\\|");
        return new Customer(Integer.parseInt(strArr[1].split("#")[1]),strArr[2].toCharArray(),Integer.parseInt(strArr[3]),strArr[4].toCharArray(),Float.parseFloat(strArr[5]),strArr[6],strArr[7].toCharArray());
    };

    private static Function<String, LineItem> mapToLineItem = (line) -> {
        String[] strArr = line.split("\\|");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new LineItem(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]),Integer.parseInt(strArr[2]),Integer.parseInt(strArr[3]),Integer.parseInt(strArr[4]) * 100,Float.parseFloat(strArr[5]),Float.parseFloat(strArr[6]),Float.parseFloat(strArr[7]),strArr[8].charAt(0),strArr[9].charAt(0),LocalDate.parse(strArr[10],formatter),LocalDate.parse(strArr[11],formatter),LocalDate.parse(strArr[12],formatter),strArr[13].toCharArray(),strArr[14].toCharArray(),strArr[15].toCharArray());
    };

    private static Function<String, Order> mapToOrder = (line) -> {
        String[] strArr = line.split("\\|");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Order(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]),strArr[2].charAt(0),Float.parseFloat(strArr[3]),LocalDate.parse(strArr[4],formatter),strArr[5].toCharArray(),strArr[6].toCharArray(),Integer.parseInt(strArr[7]),strArr[8].toCharArray());
    };

    public static Stream<Customer> processInputFileCustomer() {
        try {
            return Files.lines(Paths.get(baseDataDirectory + "/customer.tbl")).map(mapToCustomer);
        } catch (IOException e) {
            System.out.println("Customer data path seems to be wrong");
            return Stream.empty();
        }
    }

    public static Stream<LineItem> processInputFileLineItem() {
        try {
            return Files.lines(Paths.get(baseDataDirectory + "/lineitem.tbl")).map(mapToLineItem);
        } catch (IOException e) {
            System.out.println("LineItem data path seems to be wrong");
            return Stream.empty();
        }
    }

    public static Stream<Order> processInputFileOrders() {
        try {
            return Files.lines(Paths.get(baseDataDirectory + "/orders.tbl")).map(mapToOrder);
        } catch (IOException e) {
            System.out.println("Order data path seems to be wrong");
            return Stream.empty();
        }
    }

//    private long countSegment(String marketsegment){
//        Map<Integer, String> custKeyMapping = new HashMap<>();
//        processInputFileCustomer().forEach(x -> custKeyMapping.put(x.custKey,x.mktsegment));
//
//        Map<Integer, String> orderKeyMapping = new HashMap<>();
//        processInputFileOrders().forEach(x -> {
//            orderKeyMapping.put(x.orderKey, custKeyMapping.get(x.custKey));
//        });
//
//        Stream<String> stringStreamorderKeyMapping.entrySet().stream().filter(x -> x.getValue().equals(marketsegment));
//
//        return 0;
//    }

    public long getAverageQuantityPerMarketSegment(String marketsegment){
        long[] total = new long[]{0};
        long[] denominator = new long[]{0};
        processInputFileLineItem().forEach(x ->{
            if(orderKeyMapping.get(x.orderKey).equals(marketsegment)){
                total[0] += x.quantity;
                denominator[0]++;
            }
        });

        long result = total[0]/denominator[0];
        return result;
    }


    public Database(){
        // The hell are we supposed to write here?
        custKeyMapping = new HashMap<>();
        processInputFileCustomer().forEach(x -> custKeyMapping.put(x.custKey,x.mktsegment));

        // Second Mapping
        orderKeyMapping = new HashMap<>();
        processInputFileOrders().forEach(x -> {
            orderKeyMapping.put(x.orderKey, custKeyMapping.get(x.custKey));
        });
    }


    public static void main(String[] args) {
        // TODO Test your implementation
        System.out.println(new Database().getAverageQuantityPerMarketSegment("BUILDING"));
    }
}