package servlet;

import java.io.IOException;

import dao.PatientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddPatientServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)
            
            throws ServletException, IOException {
                System.out.println("SERVLET CALLED");
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