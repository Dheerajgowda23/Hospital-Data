package servlet;

import java.io.IOException;
import java.util.List;

import dao.PatientDAO;
import model.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewPatientsServlet extends HttpServlet {
    private PatientDAO dao = new PatientDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Patient> list = dao.getAllPatients();
            req.setAttribute("patients", list);
            req.getRequestDispatcher("view.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("error", "Error fetching patients: " + e.getMessage());
            res.sendRedirect("index.jsp");
        }
    }
}