package com.sarveshsbibhuty.software_project;

public class Student {


    String name;
    String schoolname;
    String Registration;
    String password;

    public Student(String name, String schoolname, String registration, String password) {
        this.name = name;
        this.schoolname = schoolname;
        Registration = registration;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public String getRegistration() {
        return Registration;
    }

    public String getPassword() {
        return password;
    }
}
