package com.czj.myShop.entity;

public class GoodsType {
    private  int goods_typeid;
    private  String goods_typename;
    private  int goods_typelevel;
    private  int goods_typeparent;


    public GoodsType() {
    }

    public GoodsType(int goods_typeid, String goods_typename, int goods_typelevel, int goods_typeparent) {
        this.goods_typeid = goods_typeid;
        this.goods_typename = goods_typename;
        this.goods_typelevel = goods_typelevel;
        this.goods_typeparent = goods_typeparent;
    }

    public int getGoods_typeid() {
        return goods_typeid;
    }

    public void setGoods_typeid(int goods_typeid) {
        this.goods_typeid = goods_typeid;
    }

    public String getGoods_typename() {
        return goods_typename;
    }

    public void setGoods_typename(String goods_typename) {
        this.goods_typename = goods_typename;
    }

    public int getGoods_typelevel() {
        return goods_typelevel;
    }

    public void setGoods_typelevel(int goods_typelevel) {
        this.goods_typelevel = goods_typelevel;
    }

    public int getGoods_typeparent() {
        return goods_typeparent;
    }

    public void setGoods_typeparent(int goods_typeparent) {
        this.goods_typeparent = goods_typeparent;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "goods_typeid=" + goods_typeid +
                ", goods_typename='" + goods_typename + '\'' +
                ", goods_typelevel=" + goods_typelevel +
                ", goods_typeparent=" + goods_typeparent +
                '}';
    }
}
