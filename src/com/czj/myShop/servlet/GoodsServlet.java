package com.czj.myShop.servlet;

import com.czj.myShop.dao.GoodsDaoImpl;
import com.czj.myShop.dao.UserDaoImpl;
import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.User;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
    private GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();
    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    public void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        goodsDaoImpl.addGoods(goods);

        response.sendRedirect("GoodsServlet?method=qureyAllGoods");
    }

    public void qureyAllGoods(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        List<Goods> goodsList = goodsDaoImpl.queryAllGoods();
        int userid = (int)request.getSession().getAttribute("userid");
        User role = userDaoImpl.getRole(userid,1);

        //try{
        if (null != role) {
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("goodsForCustomer.jsp").forward(request, response);

        } else {
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("showGoods.jsp").forward(request, response);
        }
//        }catch (Exception e){
//            request.setAttribute("goodsList", goodsList);
//            request.getRequestDispatcher("goodsForCustomer.jsp").forward(request, response);
//        }

    }

    public void qureyGoodsById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String goods_id = request.getParameter("goods_id");

        Goods goods = goodsDaoImpl.queryGoodstById(Integer.parseInt(goods_id));
        request.setAttribute("goodsInfo", goods);
        request.getRequestDispatcher("updateGoods.jsp").forward(request, response);

    }

    public void qureyGoodsByIdForSearching(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String goods_id = request.getParameter("goodsId");

        Goods goods = goodsDaoImpl.queryGoodstById(Integer.parseInt(goods_id));

        JSONObject json = new JSONObject();
        PrintWriter writer = response.getWriter();

        json.put("goods", goods);
        writer.print(json);
        writer.flush();
        writer.close();
    }

    public void deleteGoodsById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String goods_id = request.getParameter("goods_id");

        int goods = goodsDaoImpl.deleteGoodsById(Integer.parseInt(goods_id));

        response.sendRedirect("GoodsServlet?method=qureyAllGoods");
    }

    public void updateGoodsById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        BeanUtils.populate(goods, parameterMap);

        goodsDaoImpl.updateGoods(goods);

        response.sendRedirect("GoodsServlet?method=qureyAllGoods");
    }

    public void goodsDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String goods_id = request.getParameter("goods_id");

        Goods goods = goodsDaoImpl.queryGoodstById(Integer.parseInt(goods_id));
        request.setAttribute("goodsInfo", goods);
        request.getRequestDispatcher("goodsDetail.jsp").forward(request, response);

    }
}
