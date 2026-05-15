package servlet;

import java.io.IOException;

import dao.PatientDAO;
import model.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddPatientServlet extends HttpServlet {
    private PatientDAO dao = new PatientDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String disease = req.getParameter("disease");

        Patient p = new Patient(0, name, age, disease);

        try {
            dao.addPatient(p);
            req.getSession().setAttribute("success", "Patient added successfully!");
        } catch (Exception e) {
            req.getSession().setAttribute("error", "Error adding patient: " + e.getMessage());
            e.printStackTrace();
        }

        res.sendRedirect("view");
    }
}