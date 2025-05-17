package model.dao;


import model.entity.CarPark;

import java.util.List;

public interface CarParkDAO {
    CarPark getCarParkById(int id);
    List<CarPark> getAllCarParks();

}