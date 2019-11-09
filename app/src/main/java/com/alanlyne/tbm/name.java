package com.alanlyne.tbm;

public class name {

    String userID;
    String userName;
    String phone;

    public name(){

    }

    public name(String userID, String name, String phone) {
        this.userID = userID;
        this.userName = name;
        this.phone = phone;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }
}
