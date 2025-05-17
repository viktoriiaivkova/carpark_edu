package model.service;
import model.dao.ManufacturerDAO;
import model.dao.ManufacturerDAOImpl;
import model.entity.Manufacturer;

import java.util.List;

public class ManufacturerService {
    private ManufacturerDAO manufacturerDAO = new ManufacturerDAOImpl();

    public Manufacturer getManufacturerById(int id) {
        return manufacturerDAO.getManufacturerById(id);
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerDAO.getAllManufacturers();
    }
}