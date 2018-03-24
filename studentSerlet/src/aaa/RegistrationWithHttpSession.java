package aaa;

import aaa.SetJDBC.InitMysql;
import aaa.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationWithHttpSession extends HttpServlet {
    PreparedStatement pst;
    @Override
    public void init() throws ServletException {
        try {
            initJDBC();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");
        String password = new String(req.getParameter("password").getBytes("iso-8859-1"),"utf-8");
//        resp.setContentType("text/html");
//        String password = req.getParameter("password");
//        PrintWriter printWriter = resp.getWriter();
        HttpSession httpSession = req.getSession();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        System.out.println(name);
        httpSession.setAttribute("user",user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("confirm.jsp");
//        System.out.print("222222");
        requestDispatcher.forward(req,resp);
//        System.out.print("111111");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession httpSession = req.getSession();
        User user= (User) httpSession.getAttribute("user");
        try {
            pst.setString(1,user.getName());
            pst.setString(2,user.getPassword());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initJDBC() throws SQLException, ClassNotFoundException {
        Connection connection=InitMysql.getConnection();
        String sql = "insert into admin (name,password) value(?,?)";
        pst = connection.prepareStatement(sql);
    }
}
