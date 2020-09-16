package com.czj.myShop.entity;

public class Address {
    private  int address_id;
    private  String address_detail;
    private String address_username;
    private String address_userphone;
    private  int address_userid;
    private int address_level;

    public Address() {
    }

    public Address(int address_id, String address_detail, String address_username, String address_userphone, int address_userid, int address_level) {
        this.address_id = address_id;
        this.address_detail = address_detail;
        this.address_username = address_username;
        this.address_userphone = address_userphone;
        this.address_userid = address_userid;
        this.address_level = address_level;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public String getAddress_username() {
        return address_username;
    }

    public void setAddress_username(String address_username) {
        this.address_username = address_username;
    }

    public String getAddress_userphone() {
        return address_userphone;
    }

    public void setAddress_userphone(String address_userphone) {
        this.address_userphone = address_userphone;
    }

    public int getAddress_userid() {
        return address_userid;
    }

    public void setAddress_userid(int address_userid) {
        this.address_userid = address_userid;
    }

    public int getAddress_level() {
        return address_level;
    }

    public void setAddress_level(int address_level) {
        this.address_level = address_level;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address_detail='" + address_detail + '\'' +
                ", address_username='" + address_username + '\'' +
                ", address_userphone='" + address_userphone + '\'' +
                ", address_userid=" + address_userid +
                ", address_level=" + address_level +
                '}';
    }
}
