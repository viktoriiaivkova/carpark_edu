package controller;

import jakarta.servlet.ServletException;
import model.entity.CarPark;
import model.service.CarParkService;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/carparks")
public class CarParkServlet extends HttpServlet {
    private CarParkService carParkService = new CarParkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listCarParks(request, response);
    }

    private void listCarParks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CarPark> carParks = carParkService.getAllCarParks();
        request.setAttribute("carParks", carParks);
        request.getRequestDispatcher("/WEB-INF/views/carpark/list.jsp").forward(request, response);
    }
}