package com.czj.myShop.entity;

public class OrderDetail {
    private int orderdetail_id;
    private  int orderdetail_goodsid;
    private  String orderdetail_orderid;
    private  int orderdetail_goodsnum;
    private  double orderdetail_orderprice;

    public OrderDetail() {
    }

    public OrderDetail(int orderdetail_id, int orderdetail_goodsid, String orderdetail_orderid, int orderdetail_goodsnum, double orderdetail_orderprice) {
        this.orderdetail_id = orderdetail_id;
        this.orderdetail_goodsid = orderdetail_goodsid;
        this.orderdetail_orderid = orderdetail_orderid;
        this.orderdetail_goodsnum = orderdetail_goodsnum;
        this.orderdetail_orderprice = orderdetail_orderprice;
    }

    public int getOrderdetail_id() {
        return orderdetail_id;
    }

    public void setOrderdetail_id(int orderdetail_id) {
        this.orderdetail_id = orderdetail_id;
    }

    public int getOrderdetail_goodsid() {
        return orderdetail_goodsid;
    }

    public void setOrderdetail_goodsid(int orderdetail_goodsid) {
        this.orderdetail_goodsid = orderdetail_goodsid;
    }

    public String getOrderdetail_orderid() {
        return orderdetail_orderid;
    }

    public void setOrderdetail_orderid(String orderdetail_orderid) {
        this.orderdetail_orderid = orderdetail_orderid;
    }

    public int getOrderdetail_goodsnum() {
        return orderdetail_goodsnum;
    }

    public void setOrderdetail_goodsnum(int orderdetail_goodsnum) {
        this.orderdetail_goodsnum = orderdetail_goodsnum;
    }

    public double getOrderdetail_orderprice() {
        return orderdetail_orderprice;
    }

    public void setOrderdetail_orderprice(double orderdetail_orderprice) {
        this.orderdetail_orderprice = orderdetail_orderprice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderdetail_id=" + orderdetail_id +
                ", orderdetail_goodsid=" + orderdetail_goodsid +
                ", orderdetail_orderid='" + orderdetail_orderid + '\'' +
                ", orderdetail_goodsnum=" + orderdetail_goodsnum +
                ", orderdetail_orderprice=" + orderdetail_orderprice +
                '}';
    }
}
