package com.czj.myShop.entity;

public class OrderDetail {
    private String order_id;
    private int order_userId;
    private String order_userName;
    private double order_goodsPrice;
    private double order_price;
    private  int order_status;
    private  String order_time;
    private String order_address;
    private String order_phoneNumber;

    public OrderDetail() {
    }

    public OrderDetail(String order_id, int order_userId, String order_userName, double order_goodsPrice, double order_price, int order_status, String order_time, String order_address, String order_phoneNumber) {
        this.order_id = order_id;
        this.order_userId = order_userId;
        this.order_userName = order_userName;
        this.order_goodsPrice = order_goodsPrice;
        this.order_price = order_price;
        this.order_status = order_status;
        this.order_time = order_time;
        this.order_address = order_address;
        this.order_phoneNumber = order_phoneNumber;
    }

    public int getOrder_userId() {
        return order_userId;
    }

    public void setOrder_userId(int order_userId) {
        this.order_userId = order_userId;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_userName() {
        return order_userName;
    }

    public void setOrder_userName(String order_userName) {
        this.order_userName = order_userName;
    }

    public double getOrder_goodsPrice() {
        return order_goodsPrice;
    }

    public void setOrder_goodsPrice(double order_goodsPrice) {
        this.order_goodsPrice = order_goodsPrice;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_phoneNumber() {
        return order_phoneNumber;
    }

    public void setOrder_phoneNumber(String order_phoneNumber) {
        this.order_phoneNumber = order_phoneNumber;
    }
}
