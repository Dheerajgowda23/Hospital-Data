package servlet;

import dao.PatientDAO;
import model.Patient;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

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
                req.getRequestDispatcher("view.jsp");

        rd.forward(req, res);
    }
}