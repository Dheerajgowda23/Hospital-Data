package servlet;

import java.io.IOException;

import dao.PatientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeletePatientServlet extends HttpServlet {
    private PatientDAO dao = new PatientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            dao.deletePatient(id);
            req.getSession().setAttribute("success", "Patient deleted successfully!");
        } catch (Exception e) {
            req.getSession().setAttribute("error", "Error deleting patient: " + e.getMessage());
            e.printStackTrace();
        }

        res.sendRedirect("view");
    }
}