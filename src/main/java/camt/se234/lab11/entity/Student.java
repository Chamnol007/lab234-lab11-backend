package camt.se234.lab11.entity;

import java.util.Objects;

public class Student {
    String studentId;
    String name;
    String surName;
    Double gpa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
                Objects.equals(name, student.name) &&
                Objects.equals(surName, student.surName) &&
                Objects.equals(gpa, student.gpa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, name, surName, gpa);
    }

    public Student(String studentId, String name, String surName, Double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.surName = surName;
        this.gpa = gpa;

    }
  public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Double getGpa() {
        return gpa;
    }
    
}
