package model.entity;
public class CarPark {
    private int id;
    private String name;
    private String address;
    private int capacity;

    public CarPark() {}

    public CarPark(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return "CarPark [id=" + id + ", name=" + name + ", address=" + address + ", capacity=" + capacity + "]";
    }
}
