package controller;

import jakarta.servlet.ServletException;
import model.entity.Car;
import model.entity.CarPark;
import model.entity.Manufacturer;
import model.service.CarParkService;
import model.service.CarService;
import model.service.ManufacturerService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {
    private CarService carService = new CarService();
    private ManufacturerService manufacturerService = new ManufacturerService();
    private CarParkService carParkService = new CarParkService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listCars(request, response);
        } else {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "view":
                    showViewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCar(request, response);
                    break;
                default:
                    listCars(request, response);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createCar(request, response);
        } else if ("update".equals(action)) {
            updateCar(request, response);
        } else {
            listCars(request, response);
        }
    }

    private void listCars(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Car> cars = carService.getAllCars();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/views/car/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        List<CarPark> carParks = carParkService.getAllCarParks();

        request.setAttribute("manufacturers", manufacturers);
        request.setAttribute("carParks", carParks);
        request.setAttribute("mode", "create");
        request.getRequestDispatcher("/WEB-INF/views/car/form.jsp").forward(request, response);
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = carService.getCarById(id);

        request.setAttribute("car", car);
        request.setAttribute("mode", "view");
        request.getRequestDispatcher("/WEB-INF/views/car/form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = carService.getCarById(id);
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        List<CarPark> carParks = carParkService.getAllCarParks();

        request.setAttribute("car", car);
        request.setAttribute("manufacturers", manufacturers);
        request.setAttribute("carParks", carParks);
        request.setAttribute("mode", "edit");
        request.getRequestDispatcher("/WEB-INF/views/car/form.jsp").forward(request, response);
    }

    private void createCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String licensePlate = request.getParameter("licensePlate");
        String model = request.getParameter("model");
        String color = request.getParameter("color");

        int manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));
        int carParkId = Integer.parseInt(request.getParameter("carParkId"));

        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        CarPark carPark = carParkService.getCarParkById(carParkId);

        Car car = new Car(licensePlate, model, color, manufacturer, carPark);
        carService.addCar(car);

        response.sendRedirect("cars");
    }

    private void updateCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String licensePlate = request.getParameter("licensePlate");
        String model = request.getParameter("model");
        String color = request.getParameter("color");

        int manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));
        int carParkId = Integer.parseInt(request.getParameter("carParkId"));

        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        CarPark carPark = carParkService.getCarParkById(carParkId);

        Car car = new Car(licensePlate, model, color, manufacturer, carPark);
        car.setId(id);
        carService.updateCar(car);

        response.sendRedirect("cars");
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carService.deleteCar(id);
        response.sendRedirect("cars");
    }
}