package model.service;
import model.dao.CarParkDAO;
import model.dao.CarParkDAOImpl;
import model.entity.CarPark;

import java.util.List;

public class CarParkService {
    private CarParkDAO carParkDAO = new CarParkDAOImpl();
    public CarPark getCarParkById(int id) {
        return carParkDAO.getCarParkById(id);
    }
    public List<CarPark> getAllCarParks() {
        return carParkDAO.getAllCarParks();
    }
}
