package model.dao;
import model.entity.Car;
import java.util.List;
public interface CarDAO {
    void addCar(Car car);
    Car getCarById(int id);
    List<Car> getAllCars();
    void updateCar(Car car);
    void deleteCar(int id);
    List<Car> getCarsByManufacturer(int manufacturerId);
    List<Car> getCarsByCarPark(int carParkId);
}
