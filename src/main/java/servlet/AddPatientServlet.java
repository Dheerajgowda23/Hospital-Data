package servlet;

import dao.PatientDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class AddPatientServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        String name =
                req.getParameter("name");

        int age =
                Integer.parseInt(req.getParameter("age"));

        String disease =
                req.getParameter("disease");

        PatientDAO.addPatient(
                name,
                age,
                disease
        );

        res.sendRedirect("view");
    }
}