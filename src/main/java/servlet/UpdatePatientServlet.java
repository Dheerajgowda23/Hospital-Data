package servlet;

import java.io.IOException;

import dao.PatientDAO;
import model.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdatePatientServlet extends HttpServlet {
    private PatientDAO dao = new PatientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Patient p = dao.getPatientById(id);
            req.setAttribute("patient", p);
            req.getRequestDispatcher("edit.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("view");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String disease = req.getParameter("disease");

        Patient p = new Patient(id, name, age, disease);

        try {
            dao.updatePatient(p);
            req.getSession().setAttribute("success", "Patient updated successfully!");
        } catch (Exception e) {
            req.getSession().setAttribute("error", "Error updating patient: " + e.getMessage());
            e.printStackTrace();
        }

        res.sendRedirect("view");
    }
}