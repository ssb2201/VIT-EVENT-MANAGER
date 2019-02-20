package com.sarveshsbibhuty.software_project;


public class club {

    String clubname;
    String schoolname;
    String username;
    String password;

    public club(String clubname, String schoolname, String username, String password) {
        this.clubname = clubname;
        this.schoolname = schoolname;
        this.username = username;
        this.password = password;
    }

    public String getClubname() {
        return clubname;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
