package com.czj.myShop.servlet;

import com.czj.myShop.dao.CartDaoImpl;
import com.czj.myShop.dao.GoodsDaoImpl;
import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.ShoppingCart;
import com.czj.myShop.entity.ShowCart;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@
        WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
    private CartDaoImpl cartDaoImpl = new CartDaoImpl();
    private GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();


    public ShoppingCart queryGoodsFromCart(int goodsId, int userId) throws SQLException {
        return cartDaoImpl.queryGoodsFromCart(goodsId, userId);
    }

    public void addGoodsToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        int userid = (int) request.getSession().getAttribute("userid");

        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
        int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));

        int totalPrice = goodsPrice * goodsNumber;
        JSONObject json = new JSONObject();
        PrintWriter writer = response.getWriter();
        if (queryGoodsFromCart(goodsId, userid) != null) {
            cartDaoImpl.addGoodsToCart(goodsId, userid, goodsNumber, totalPrice);
            json.put("msg1", "成功添加");
            json.put("goodsNumber", goodsNumber);
            json.put("msg2", "个到购物车！");
            writer.print(json);
            writer.flush();
        } else {
            cartDaoImpl.insertGoodsToCart(goodsId, userid, goodsNumber, totalPrice);
//            writer.write("{\"result\":\"\"}");
            json.put("msg1", "成功添加");
            json.put("goodsNumber", goodsNumber);
            json.put("msg2", "个到购物车！");
            writer.print(json);
            writer.flush();
        }
        writer.close();

    }

    public void getMyCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        int userid = (int) request.getSession().getAttribute("userid");
        List<ShoppingCart> myCart = cartDaoImpl.getMyCart(userid);
        JSONObject json = new JSONObject();
        PrintWriter writer = response.getWriter();
        List<ShowCart> showCarts = new ArrayList<>();
        for (ShoppingCart cart : myCart) {
            int shoppingcart_goodsid = cart.getShoppingcart_goodsid();
            Goods goods = goodsDaoImpl.queryGoodstById(shoppingcart_goodsid);

            int goodsId = goods.getGoods_id();
            int goodsNum = cart.getShoppingcart_goodsnum();
            int totalprice = cart.getShoppingcart_totalprice();

            String goodsName = goods.getGoods_name();
            int goodsPrice = goods.getGoods_price();
            String goodsPicture = goods.getGoods_picture();
            showCarts.add(new ShowCart(goodsId, goodsName, goodsPicture, goodsPrice, goodsNum, totalprice));
        }
        json.put("showCart", showCarts);
        writer.print(json);
        writer.flush();
        writer.close();
    }

    public void manageMyCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int userid = (int) request.getSession().getAttribute("userid");
        List<ShoppingCart> myCart = cartDaoImpl.getMyCart(userid);
        List<ShowCart> allCarts = new ArrayList<>();
        for (ShoppingCart cart : myCart) {
            int shoppingcart_goodsid = cart.getShoppingcart_goodsid();
            Goods goods = goodsDaoImpl.queryGoodstById(shoppingcart_goodsid);

            int goodsId = goods.getGoods_id();
            int goodsNum = cart.getShoppingcart_goodsnum();
            int totalprice = cart.getShoppingcart_totalprice();

            String goodsName = goods.getGoods_name();
            int goodsPrice = goods.getGoods_price();
            String goodsPicture = goods.getGoods_picture();
            allCarts.add(new ShowCart(goodsId, goodsName, goodsPicture, goodsPrice, goodsNum, totalprice));
        }

        request.setAttribute("allCarts", allCarts);
        request.getRequestDispatcher("myCart.jsp").forward(request, response);
    }

    public boolean isEmpty(int userId, int goodsId) throws SQLException, ClassNotFoundException, ServletException, IOException {
        ShoppingCart cart = queryGoodsFromCart(userId, goodsId);
        return  null  == cart ? true : false;
    }

    public void deleteTheCart() throws SQLException, ClassNotFoundException, ServletException, IOException {
        cartDaoImpl.deleteTheCart();
    }

    public void goodsNumberDown(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int userid = (int) request.getSession().getAttribute("userid");

        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
        int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

        cartDaoImpl.goodsNumberDown(userid, goodsId, goodsNumber, goodsPrice, totalPrice);

        System.out.println();
        if (isEmpty(userid, goodsId)) {
            deleteTheCart();
        }
        response.sendRedirect("CartServlet?method=manageMyCart");

    }

    public void goodsNumberUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        int userid = (int) request.getSession().getAttribute("userid");

        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
        int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

        cartDaoImpl.goodsNumberUp(userid, goodsId, goodsNumber, goodsPrice, totalPrice);

        response.sendRedirect("CartServlet?method=manageMyCart");
    }

    public  void clearCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userid = (int)request.getSession().getAttribute("userid");
        cartDaoImpl.clearCart(userid);

        response.sendRedirect("CartServlet?method=manageMyCart");
    }
}




