package CarPark;

public class Car {
    private String brand;
    private LicensePlate licensePlate;
    private static int chassisNumber = 0;

    public Car(String brand, LicensePlate licensePlate){
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.chassisNumber = chassisNumber++;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String toString(){
        return "Car " + ": (Brand " + brand + ", License Plate: " + licensePlate.toString() + ")";
    }
}