package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import util.DBConnection;

public class PatientDAO {

    public static void addPatient(
            String name,
            int age,
            String disease) {

        try (Connection con =
                     DBConnection.getConnection()) {

            String sql =
                    "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static List<Patient> getAllPatients() {

        List<Patient> list =
                new ArrayList<>();

        try (Connection con =
                     DBConnection.getConnection()) {

            ResultSet rs =
                    con.createStatement()
                            .executeQuery("SELECT * FROM patients");

            while (rs.next()) {
                System.out.println("DATA FOUND");

                list.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("disease")
                ));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        return list;
    }
    public static void deletePatient(int id) {

    try(Connection con =
            DBConnection.getConnection()) {

        String sql =
                "DELETE FROM patients WHERE id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

    } catch(Exception e) {

        e.printStackTrace();
    }
}
    public static void updatePatient(
        int id,
        String name,
        int age,
        String disease) {

    try(Connection con =
            DBConnection.getConnection()) {

        String sql =
                "UPDATE patients SET name=?, age=?, disease=? WHERE id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, disease);
        ps.setInt(4, id);

        ps.executeUpdate();
        System.out.println("PATIENT ADDED SUCCESSFULLY");
    } catch(Exception e) {

        System.out.println(e);
        e.printStackTrace();
    }
}
}