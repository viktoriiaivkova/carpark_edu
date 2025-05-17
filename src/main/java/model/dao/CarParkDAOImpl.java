package model.dao;
import model.DatabaseConnection;
import model.entity.CarPark;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarParkDAOImpl implements CarParkDAO {
    private Connection connection = DatabaseConnection.getConnection();
    @Override
    public CarPark getCarParkById(int id) {
        String sql = "SELECT * FROM carpark WHERE id = ?";
        CarPark carPark = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    carPark = new CarPark();
                    carPark.setId(rs.getInt("id"));
                    carPark.setName(rs.getString("name"));
                    carPark.setAddress(rs.getString("address"));
                    carPark.setCapacity(rs.getInt("capacity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carPark;
    }

    @Override
    public List<CarPark> getAllCarParks() {
        List<CarPark> carParks = new ArrayList<>();
        String sql = "SELECT * FROM carpark";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CarPark carPark = new CarPark();
                carPark.setId(rs.getInt("id"));
                carPark.setName(rs.getString("name"));
                carPark.setAddress(rs.getString("address"));
                carPark.setCapacity(rs.getInt("capacity"));
                carParks.add(carPark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carParks;
    }
}