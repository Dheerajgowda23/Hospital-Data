package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import util.DBConnection;

public class PatientDAO {

    public void addPatient(Patient p) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Patients(name, age, disease) VALUES (?, ?, ?)")) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDisease());
            ps.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws Exception {
        List<Patient> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Patients ORDER BY id ASC");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setDisease(rs.getString("disease"));
                list.add(p);
            }
        }
        return list;
    }

    public Patient getPatientById(int id) throws Exception {
        Patient p = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Patients WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Patient();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setAge(rs.getInt("age"));
                    p.setDisease(rs.getString("disease"));
                }
            }
        }
        return p;
    }

    public void updatePatient(Patient p) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Patients SET name=?, age=?, disease=? WHERE id=?")) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDisease());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        }
    }

    public void deletePatient(int id) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Patients WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}