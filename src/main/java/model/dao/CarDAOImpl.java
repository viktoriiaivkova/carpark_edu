package model.dao;
import model.DatabaseConnection;
import model.entity.Car;
import model.entity.CarPark;
import model.entity.Manufacturer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    private Connection connection = DatabaseConnection.getConnection();

    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO car (license_plate, model, color, manufacturer_id, carpark_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, car.getLicensePlate());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getColor());
            stmt.setInt(4, car.getManufacturer().getId());
            stmt.setInt(5, car.getCarPark().getId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    car.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car getCarById(int id) {
        String sql = "SELECT c.*, m.name as manufacturer_name, m.country, m.founded_year, " +
                "cp.name as carpark_name, cp.address, cp.capacity " +
                "FROM car c " +
                "LEFT JOIN manufacturer m ON c.manufacturer_id = m.id " +
                "LEFT JOIN carpark cp ON c.carpark_id = cp.id " +
                "WHERE c.id = ?";
        Car car = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    car = new Car();
                    car.setId(rs.getInt("id"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setModel(rs.getString("model"));
                    car.setColor(rs.getString("color"));

                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.setId(rs.getInt("manufacturer_id"));
                    manufacturer.setName(rs.getString("manufacturer_name"));
                    manufacturer.setCountry(rs.getString("country"));
                    manufacturer.setFoundedYear(rs.getInt("founded_year"));
                    car.setManufacturer(manufacturer);

                    CarPark carPark = new CarPark();
                    carPark.setId(rs.getInt("carpark_id"));
                    carPark.setName(rs.getString("carpark_name"));
                    carPark.setAddress(rs.getString("address"));
                    carPark.setCapacity(rs.getInt("capacity"));
                    car.setCarPark(carPark);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT c.*, m.name as manufacturer_name, m.country, m.founded_year, " +
                "cp.name as carpark_name, cp.address, cp.capacity " +
                "FROM car c " +
                "LEFT JOIN manufacturer m ON c.manufacturer_id = m.id " +
                "LEFT JOIN carpark cp ON c.carpark_id = cp.id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setLicensePlate(rs.getString("license_plate"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(rs.getInt("manufacturer_id"));
                manufacturer.setName(rs.getString("manufacturer_name"));
                manufacturer.setCountry(rs.getString("country"));
                manufacturer.setFoundedYear(rs.getInt("founded_year"));
                car.setManufacturer(manufacturer);
                CarPark carPark = new CarPark();
                carPark.setId(rs.getInt("carpark_id"));
                carPark.setName(rs.getString("carpark_name"));
                carPark.setAddress(rs.getString("address"));
                carPark.setCapacity(rs.getInt("capacity"));
                car.setCarPark(carPark);
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void updateCar(Car car) {
        String sql = "UPDATE car SET license_plate = ?, model = ?, color = ?, " +
                "manufacturer_id = ?, carpark_id = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, car.getLicensePlate());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getColor());
            stmt.setInt(4, car.getManufacturer().getId());
            stmt.setInt(5, car.getCarPark().getId());
            stmt.setInt(6, car.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCar(int id) {
        String sql = "DELETE FROM car WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getCarsByManufacturer(int manufacturerId) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT c.*, m.name as manufacturer_name, m.country, m.founded_year, " +
                "cp.name as carpark_name, cp.address, cp.capacity " +
                "FROM car c " +
                "LEFT JOIN manufacturer m ON c.manufacturer_id = m.id " +
                "LEFT JOIN carpark cp ON c.carpark_id = cp.id " +
                "WHERE c.manufacturer_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, manufacturerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setId(rs.getInt("id"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setModel(rs.getString("model"));
                    car.setColor(rs.getString("color"));


                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.setId(rs.getInt("manufacturer_id"));
                    manufacturer.setName(rs.getString("manufacturer_name"));
                    manufacturer.setCountry(rs.getString("country"));
                    manufacturer.setFoundedYear(rs.getInt("founded_year"));
                    car.setManufacturer(manufacturer);

                    CarPark carPark = new CarPark();
                    carPark.setId(rs.getInt("carpark_id"));
                    carPark.setName(rs.getString("carpark_name"));
                    carPark.setAddress(rs.getString("address"));
                    carPark.setCapacity(rs.getInt("capacity"));
                    car.setCarPark(carPark);

                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> getCarsByCarPark(int carParkId) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT c.*, m.name as manufacturer_name, m.country, m.founded_year, " +
                "cp.name as carpark_name, cp.address, cp.capacity " +
                "FROM car c " +
                "LEFT JOIN manufacturer m ON c.manufacturer_id = m.id " +
                "LEFT JOIN carpark cp ON c.carpark_id = cp.id " +
                "WHERE c.carpark_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carParkId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setId(rs.getInt("id"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setModel(rs.getString("model"));
                    car.setColor(rs.getString("color"));

                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.setId(rs.getInt("manufacturer_id"));
                    manufacturer.setName(rs.getString("manufacturer_name"));
                    manufacturer.setCountry(rs.getString("country"));
                    manufacturer.setFoundedYear(rs.getInt("founded_year"));
                    car.setManufacturer(manufacturer);

                    CarPark carPark = new CarPark();
                    carPark.setId(rs.getInt("carpark_id"));
                    carPark.setName(rs.getString("carpark_name"));
                    carPark.setAddress(rs.getString("address"));
                    carPark.setCapacity(rs.getInt("capacity"));
                    car.setCarPark(carPark);

                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}