package servlet;

import java.io.IOException;

import dao.PatientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddPatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String disease = req.getParameter("disease");

            PatientDAO dao = new PatientDAO();

            dao.addPatient(name, age, disease);

            res.sendRedirect("view");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}