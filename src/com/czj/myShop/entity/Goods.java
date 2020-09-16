package com.czj.myShop.entity;

public class Goods {
    private int goods_id;
    private String goods_name;
    private String goods_date;
    private String goods_picture;
    private int goods_price;
    private int goods_star;
    private String goods_info;
    private int goods_typeid;

    public Goods() {
    }

    public Goods(int goods_id, String goods_name, String goods_date, String goods_picture, int goods_price, int goods_star, String goods_info, int goods_typeid) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_date = goods_date;
        this.goods_picture = goods_picture;
        this.goods_price = goods_price;
        this.goods_star = goods_star;
        this.goods_info = goods_info;
        this.goods_typeid = goods_typeid;
    }

    public Goods( String goods_name, String goods_date, String goods_picture, int goods_price,  String goods_info, int goods_typeid) {
        this.goods_name = goods_name;
        this.goods_date = goods_date;
        this.goods_picture = goods_picture;
        this.goods_price = goods_price;
        this.goods_info = goods_info;
        this.goods_typeid = goods_typeid;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_date() {
        return goods_date;
    }

    public void setGoods_date(String goods_date) {
        this.goods_date = goods_date;
    }

    public String getGoods_picture() {
        return goods_picture;
    }

    public void setGoods_picture(String goods_picture) {
        this.goods_picture = goods_picture;
    }

    public int getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(int goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_star() {
        return goods_star;
    }

    public void setGoods_star(int goods_star) {
        this.goods_star = goods_star;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    public int getGoods_typeid() {
        return goods_typeid;
    }

    public void setGoods_typeid(int goods_typeid) {
        this.goods_typeid = goods_typeid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_date='" + goods_date + '\'' +
                ", goods_picture='" + goods_picture + '\'' +
                ", goods_price=" + goods_price +
                ", goods_star=" + goods_star +
                ", goods_info='" + goods_info + '\'' +
                ", goods_typeid=" + goods_typeid +
                '}';
    }
}
