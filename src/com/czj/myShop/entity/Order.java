package com.czj.myShop.entity;

public class Order {
    private String order_id;
    private  int order_userid;
    private  int order_goodsid;
    private double order_price;
    private double order_goodsprice;
    private  int order_status;
    private  String order_time;
    private int order_addressid;

    public Order() {
    }

    public Order(String order_id, int order_userid, int order_goodsid, double order_price, double order_goodsprice, int order_status, String order_time, int order_addressid) {
        this.order_id = order_id;
        this.order_userid = order_userid;
        this.order_goodsid = order_goodsid;
        this.order_price = order_price;
        this.order_goodsprice = order_goodsprice;
        this.order_status = order_status;
        this.order_time = order_time;
        this.order_addressid = order_addressid;
    }

    public Order(int order_userid, int order_goodsid, double order_price, double goods_price, int order_status, String order_time, int order_addressid) {
        this.order_userid = order_userid;
        this.order_goodsid = order_goodsid;
        this.order_price = order_price;
        this.order_goodsprice = goods_price;
        this.order_status = order_status;
        this.order_time = order_time;
        this.order_addressid = order_addressid;
    }


    public double getOrder_goodsprice() {
        return order_goodsprice;
    }

    public void setOrder_goodsprice(double order_goodsprice) {
        this.order_goodsprice = order_goodsprice;
    }

    public int getOrder_goodsid() {
        return order_goodsid;
    }

    public void setOrder_goodsid(int order_goodsid) {
        this.order_goodsid = order_goodsid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getOrder_userid() {
        return order_userid;
    }

    public void setOrder_userid(int order_userid) {
        this.order_userid = order_userid;
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

    public int getOrder_addressid() {
        return order_addressid;
    }

    public void setOrder_addressid(int order_addressid) {
        this.order_addressid = order_addressid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_userid=" + order_userid +
                ", order_goodsid=" + order_goodsid +
                ", order_price=" + order_price +
                ", order_status=" + order_status +
                ", order_time='" + order_time + '\'' +
                ", order_addressid=" + order_addressid +
                '}';
    }
}
