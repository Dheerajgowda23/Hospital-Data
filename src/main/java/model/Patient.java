package model;

public class Patient {

    public int patientId;

    public String name;

    public int age;

    public String disease;

    public Patient(
            int patientId,
            String name,
            int age,
            String disease) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}