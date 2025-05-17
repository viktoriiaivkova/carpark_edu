package model.entity;
public class Manufacturer {
    private int id;
    private String name;
    private String country;
    private Integer foundedYear;

    public Manufacturer() {}

    public Manufacturer(String name, String country, Integer foundedYear) {
        this.name = name;
        this.country = country;
        this.foundedYear = foundedYear;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public Integer getFoundedYear() { return foundedYear; }
    public void setFoundedYear(Integer foundedYear) { this.foundedYear = foundedYear; }

    @Override
    public String toString() {
        return "Manufacturer [id=" + id + ", name=" + name + ", country=" + country + ", foundedYear=" + foundedYear + "]";
    }
}
