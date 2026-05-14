package servlet;

import java.io.IOException;
import java.util.List;

import dao.PatientDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Patient;
@WebServlet("/view")
public class ViewPatientsServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        List<Patient> list =
                PatientDAO.getAllPatients();

        req.setAttribute(
                "patients",
                list
        );

        RequestDispatcher rd =
                req.getRequestDispatcher("/view.jsp");

        rd.forward(req, res);
    }
}