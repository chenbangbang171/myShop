package com.czj.myShop.entity;

public class Appraise {
    private String orderId;
    private String userName;
    private String goodsName;
    private String goodsPic;
    private String ordertTime;
    private int star;
    private String appraiseContext;

    public Appraise(String orderId) {
        this.orderId = orderId;
    }

    public Appraise(String orderId, String userName, String goodsName, String goodsPic, String ordertTime, int star, String appraiseContext) {
        this.orderId = orderId;
        this.userName = userName;
        this.goodsName = goodsName;
        this.goodsPic = goodsPic;
        this.ordertTime = ordertTime;
        this.star = star;
        this.appraiseContext = appraiseContext;
    }

    public Appraise(String orderId, String userName, String goodsName, String goodsPic, String ordertTime, int star) {
        this.orderId = orderId;
        this.userName = userName;
        this.goodsName = goodsName;
        this.goodsPic = goodsPic;
        this.ordertTime = ordertTime;
        this.star = star;
    }

    public Appraise(String orderId, String userName,  int star, String appraiseContext) {
        this.orderId = orderId;
        this.userName = userName;
        this.star = star;
        this.appraiseContext = appraiseContext;
    }

    public Appraise(String orderId, String username, String goods_name, String goods_pic, String order_time) {
        this.orderId = orderId;
        this.goodsName = goods_name;
        this.userName = username;
        this.goodsPic = goods_pic;
        this.ordertTime = order_time;
    }


    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getOrdertTime() {
        return ordertTime;
    }

    public void setOrdertTime(String ordertTime) {
        this.ordertTime = ordertTime;
    }

    public String getAppraiseContext() {
        return appraiseContext;
    }

    public void setAppraiseContext(String appraiseContext) {
        this.appraiseContext = appraiseContext;
    }

    @Override
    public String toString() {
        return "Appraise{" +
                "orderId='" + orderId + '\'' +
                ", userName='" + userName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPic='" + goodsPic + '\'' +
                ", ordertTime='" + ordertTime + '\'' +
                ", star=" + star +
                ", appraiseContext='" + appraiseContext + '\'' +
                '}';
    }
}
