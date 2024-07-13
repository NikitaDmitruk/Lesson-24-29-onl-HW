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
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private final OperationService operationService = new OperationService();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> history = operationService.getAllOperations();
        gson.toJson(history, resp.getWriter());
    }
}
