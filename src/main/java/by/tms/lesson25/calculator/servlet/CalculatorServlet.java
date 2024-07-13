package by.tms.lesson25.calculator.servlet;

import by.tms.lesson25.calculator.model.Operation;
import by.tms.lesson25.calculator.service.OperationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    private final OperationService operationService = new OperationService();
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");
        Operation operation = new Operation(Double.parseDouble(num1), Double.parseDouble(num2), type);
        operation = operationService.execute(operation);
        gson.toJson(operation, resp.getWriter());
    }
}
