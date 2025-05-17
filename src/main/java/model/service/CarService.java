package model.service;
import model.dao.CarDAO;
import model.dao.CarDAOImpl;
import model.entity.Car;

import java.util.List;

public class CarService {
    private CarDAO carDAO = new CarDAOImpl();

    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    public Car getCarById(int id) {
        return carDAO.getCarById(id);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    public void deleteCar(int id) {
        carDAO.deleteCar(id);
    }

    public List<Car> getCarsByManufacturer(int manufacturerId) {
        return carDAO.getCarsByManufacturer(manufacturerId);
    }

    public List<Car> getCarsByCarPark(int carParkId) {
        return carDAO.getCarsByCarPark(carParkId);
    }
}
