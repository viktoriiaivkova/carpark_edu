package model.dao;
import model.DatabaseConnection;
import model.entity.Manufacturer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAOImpl implements ManufacturerDAO {
    private Connection connection = DatabaseConnection.getConnection();
    @Override
    public Manufacturer getManufacturerById(int id) {
        String sql = "SELECT * FROM manufacturer WHERE id = ?";
        Manufacturer manufacturer = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    manufacturer = new Manufacturer();
                    manufacturer.setId(rs.getInt("id"));
                    manufacturer.setName(rs.getString("name"));
                    manufacturer.setCountry(rs.getString("country"));
                    manufacturer.setFoundedYear(rs.getInt("founded_year"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturer;
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        String sql = "SELECT * FROM manufacturer";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(rs.getInt("id"));
                manufacturer.setName(rs.getString("name"));
                manufacturer.setCountry(rs.getString("country"));
                manufacturer.setFoundedYear(rs.getInt("founded_year"));
                manufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }


}
