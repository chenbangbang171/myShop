package com.czj.myShop.servlet;

import com.czj.myShop.dao.UserDaoImpl;
import com.czj.myShop.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

// http://localhost:8080/Day40_BaseServlet/student.action?method=addStudent
// http://localhost:8080/Day40_BaseServlet/student.action?method=listStudent

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {

    /**
     * 类内使用StudentDao层对象，用于操作数据库Student相关内容
     */
    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
            System.out.println(user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        userDaoImpl.addUser(user);

        // 重定向到indexServlet
        // req.getRequestDispatcher()
        response.sendRedirect("UserServlet?method=queryAllUsers");
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));

        userDaoImpl.deleteUserById(id);

        response.sendRedirect("UserServlet?method=queryAllUsers");
    }

    public void queryUserById(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));

        userDaoImpl.queryUsertById(id);

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDaoImpl.queryUsertByNameAndPwd(username,password);
        if(user != null){
            request.getSession().setAttribute("username",user.getUsername());
            request.getSession().setAttribute("password",user.getPassword());
            response.addCookie(new Cookie("username",username));
            response.addCookie(new Cookie("password",password));
            request.getSession().setMaxInactiveInterval(60*30);

            response.sendRedirect("main.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }

    }


    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        request.getSession().setAttribute("username",null);
        response.sendRedirect("index.jsp");

    }



    public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        //
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        String result = "";
        if (!(pwd1.equals(pwd2))) {
            result = "两次输入不一致";
        }

        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.flush();
        writer.close();
    }

    public void updateyUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

       userDaoImpl.updateUser(user);

       // response.sendRedirect("UserServlet?method=queryAllUsers");

    }

    public  void  queryAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        List<User> list =  userDaoImpl.queryAllUsers();


        response.sendRedirect("showUsers.jsp");
    }
}
