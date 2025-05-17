package model.dao;
import model.entity.Manufacturer;
import java.util.List;
public interface ManufacturerDAO {
    Manufacturer getManufacturerById(int id);
    List<Manufacturer> getAllManufacturers();

}