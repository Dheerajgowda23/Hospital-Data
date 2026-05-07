package servlet;

import java.io.IOException;

import dao.PatientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatePatientServlet
        extends HttpServlet {

    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        req.getParameter("id")
                );

        String name =
                req.getParameter("name");

        int age =
                Integer.parseInt(
                        req.getParameter("age")
                );

        String disease =
                req.getParameter("disease");

        PatientDAO.updatePatient(
                id,
                name,
                age,
                disease
        );

        res.sendRedirect("view");
    }
}