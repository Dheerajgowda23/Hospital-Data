package servlet;

import java.io.IOException;

import dao.PatientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletePatientServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                req.getParameter("id")
        );

        PatientDAO.deletePatient(id);

        res.sendRedirect("view");
    }
}