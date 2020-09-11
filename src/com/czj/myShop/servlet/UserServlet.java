package com.czj.myShop.servlet;

import com.czj.myShop.dao.UserDaoImpl;
import com.czj.myShop.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

       // response.sendRedirect("UserServlet?method=queryAllUsers");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User result = userDaoImpl.queryUsertByNameAndPwd(username,password);
        if(result != null){
            response.sendRedirect("main.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }

        // response.sendRedirect("UserServlet?method=queryAllUsers");
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
