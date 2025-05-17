package model.entity;

public class Car {
    private int id;
    private String licensePlate;
    private String model;
    private String color;
    private Manufacturer manufacturer;
    private CarPark carPark;

    public Car() {}

    public Car(String licensePlate, String model, String color, Manufacturer manufacturer, CarPark carPark) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.manufacturer = manufacturer;
        this.carPark = carPark;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Manufacturer getManufacturer() { return manufacturer; }
    public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }
    public CarPark getCarPark() { return carPark; }
    public void setCarPark(CarPark carPark) { this.carPark = carPark; }

    @Override
    public String toString() {
        return "Car [id=" + id + ", licensePlate=" + licensePlate + ", model=" + model +
                ", color=" + color + ", manufacturer=" + manufacturer + ", carPark=" + carPark + "]";
    }
}