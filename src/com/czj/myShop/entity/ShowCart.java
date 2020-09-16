package com.czj.myShop.entity;

public class ShowCart {
    private  int goodsId;
    private String goodsName;
    private String goodsPicture;
    private int goodsPrice;
    private  int goodsNumber;
    private  int totalPrice;

    public ShowCart() {
    }

    public ShowCart(int goodsId, String goodsName, String goodsPicture, int goodsPrice, int goodsNumber, int totalPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPicture = goodsPicture;
        this.goodsPrice = goodsPrice;
        this.goodsNumber = goodsNumber;
        this.totalPrice = totalPrice;
    }

    public ShowCart(String goodsName, String goodsPicture, int goodsPrice, int goodsNumber, int  totalPrice) {
        this.goodsName = goodsName;
        this.goodsPicture = goodsPicture;
        this.goodsPrice = goodsPrice;
        this.goodsNumber = goodsNumber;
        this.totalPrice = totalPrice;

    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
}
