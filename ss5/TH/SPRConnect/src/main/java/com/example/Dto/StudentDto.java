package com.example.Dto;

public class StudentDto {
    private Integer codeStudent;
    private String nameStudent;
    private Double point;
    private Integer gender;

    public StudentDto() {
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public StudentDto(Integer codeStudent, String nameStudent, Double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public StudentDto(String nameStudent, double point, Integer gender) {
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
