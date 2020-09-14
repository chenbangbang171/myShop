package com.czj.myShop.servlet;

import com.czj.myShop.dao.UserDaoImpl;
import com.czj.myShop.entity.User;
import com.czj.myShop.utils.GenerateLinkUtils;
import com.czj.myShop.utils.SendJMailNew;
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

import static com.czj.myShop.utils.GenerateLinkUtils.verifyCheckcode;
import static com.czj.myShop.utils.SendJMailNew.sendMail;

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

    /**
     *   注册用户并发送激活邮件
     * @param request
     * @param response
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();
        BeanUtils.populate(user, parameterMap);

        //默认状态为0，即未激活状态
        user.setFlag(0);

        //获取用户输入的邮箱
        String email = user.getEmail();

        //数据库添加添加用户，此时是未激活状态
        userDaoImpl.addUser(user);

        //发送激活邮件
        sendMail(queryUserByEmailForActive(email));

        //提示用户激活
        response.getWriter().write("激活邮件已发送，请注意查收并激活！");
    }

    /**
     *  用户点击激活连接，激活账号状态
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        //String id, String checkCode,
        String id = request.getParameter("id");
        String checkCode = request.getParameter("checkCode");

        int idInt = Integer.parseInt(id);

        //根据用户id查找用户
        User user = findUserById(idInt);

        //验证无误，状态更改为1，即激活
        if (verifyCheckcode(user, checkCode)) {
            //修改状态
            int flag = 1;
            //修改数据库激活状态并添加激活码
            int result = activeUser(flag, idInt, checkCode);
            if (result > 0) {
                response.getWriter().write("恭喜，激活成功！");
            }
        }
    }

    /**
     *   激活用户，被active()调用
     * @param flag 激活状态码
     * @param id    用户id
     * @param checkCode 用户激活码
     * @return
     * @throws SQLException
     */
    public int activeUser(int flag, int id, String checkCode) throws SQLException {
        return userDaoImpl.updateFlag(flag, id, checkCode);
    }

    public User findUserById(int id) throws SQLException {
        return userDaoImpl.queryUsertById(id);
    }

    /**
     *   专门为active()方法服务的查询方法
     * @param email 用户邮箱
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public User queryUserByEmailForActive(String email) throws IOException, SQLException {
        return userDaoImpl.queryUserByEmail(email);
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

    public void queryUserByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String email = request.getParameter("checkEmail");

        User result = userDaoImpl.queryUserByEmail(email);
        String html = "";
        if (result != null) {
            html = "该邮箱已被注册！";
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.print(html);
        writer.flush();
        writer.close();

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDaoImpl.queryUsertByNameAndPwd(username, password);
        if (user != null ) {
            if ( isActive(user.getId() )){
                request.getSession().setAttribute("username", user.getUsername());
                request.getSession().setAttribute("password", user.getPassword());
                response.addCookie(new Cookie("username", username));
                response.addCookie(new Cookie("password", password));
                request.getSession().setMaxInactiveInterval(60 * 30);

                response.sendRedirect("main.jsp");
            }else{
                response.getWriter().write("此账号未激活，请激活后登录！");
            }

        } else {
            response.sendRedirect("index.jsp");
        }

    }

    /**
     *  根据id查询用户的状态码,判断是否是激活状态
     * @param id
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public boolean isActive(int id) throws IOException, SQLException {
      return userDaoImpl.isActive(id) != null ? true: false;
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        request.getSession().invalidate();
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

    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String result = "img/wrong.jpg";

        //获取用户输入的验证码
        String checkCodeFromUser = request.getParameter("checkCode");

        //获取sessio中的值，也就是验证码里面的值
        String checkCode = (String) request.getSession().getAttribute("checkCode");

        if (checkCode.equals(checkCodeFromUser)) {
            result = "img/right.jpg";
        }

        response.setContentType("text/html;charset=UTF-8");

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

    public void queryAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        List<User> list = userDaoImpl.queryAllUsers();


        response.sendRedirect("showUsers.jsp");
    }
}
