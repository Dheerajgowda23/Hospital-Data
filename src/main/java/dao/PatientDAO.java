package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import util.DBConnection;

public class PatientDAO {

    // ADD PATIENT
    public void addPatient(String name, int age, String disease) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO Patients(name, age, disease) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, disease);

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // VIEW ALL PATIENTS
    public List<Patient> getAllPatients() throws Exception {

        List<Patient> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM Patients";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Patient p = new Patient();

            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setDisease(rs.getString("disease"));

            list.add(p);
        }

        rs.close();
        ps.close();
        con.close();

        return list;
    }
}