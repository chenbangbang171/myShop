package com.czj.myShop.entity;

import java.util.List;

public class ShoppingCart {
    private int shoppingcart_userid;
    private  int shoppingcart_goodsid;
    private  int shoppingcart_goodsnum;
    private  int shoppingcart_totalprice;

    public ShoppingCart() {
    }

    public ShoppingCart(int shoppingcart_userid, int shoppingcart_goodsid, int shoppingcart_goodsnum, int shoppingcart_totalprice) {
        this.shoppingcart_userid = shoppingcart_userid;
        this.shoppingcart_goodsid = shoppingcart_goodsid;
        this.shoppingcart_goodsnum = shoppingcart_goodsnum;
        this.shoppingcart_totalprice = shoppingcart_totalprice;
    }

    public int getShoppingcart_userid() {
        return shoppingcart_userid;
    }

    public void setShoppingcart_userid(int shoppingcart_userid) {
        this.shoppingcart_userid = shoppingcart_userid;
    }


    public int getShoppingcart_goodsnum() {
        return shoppingcart_goodsnum;
    }

    public void setShoppingcart_goodsnum(int shoppingcart_goodsnum) {
        this.shoppingcart_goodsnum = shoppingcart_goodsnum;
    }

    public int getShoppingcart_totalprice() {
        return shoppingcart_totalprice;
    }


    public int getShoppingcart_goodsid() {
        return shoppingcart_goodsid;
    }

    public void setShoppingcart_goodsid(int shoppingcart_goodsid) {
        this.shoppingcart_goodsid = shoppingcart_goodsid;
    }

    public void setShoppingcart_totalprice(int shoppingcart_totalprice) {
        this.shoppingcart_totalprice = shoppingcart_totalprice;
    }


}
