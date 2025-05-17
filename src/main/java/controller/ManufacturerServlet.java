package controller;

import jakarta.servlet.ServletException;
import model.entity.Manufacturer;
import model.service.ManufacturerService;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/manufacturers")
public class ManufacturerServlet extends HttpServlet {
    private ManufacturerService manufacturerService = new ManufacturerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listManufacturers(request, response);
    }

    private void listManufacturers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        request.setAttribute("manufacturers", manufacturers);
        request.getRequestDispatcher("/WEB-INF/views/manufacturer/list.jsp").forward(request, response);
    }
}