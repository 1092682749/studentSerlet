package aaa;

import aaa.SetJDBC.InitMysql;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationWithCookie extends HttpServlet {
    PreparedStatement pst;
    private void initJDBC() throws SQLException, ClassNotFoundException {
        Connection connection=InitMysql.getConnection();
        String sql = "insert into admin (name,password) value(?,?)";
        pst = connection.prepareStatement(sql);

    }
    private void setParameters(String name,String password) throws SQLException {
        pst.setString(1,name);
        pst.setString(2,password);
    }
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
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        System.out.println(name.length());
        System.out.println(password.length());
        if (name.length()==0||password.length()==0)
        {
            printWriter.println("<script>alert(\"不能有空值\");</script>");
            return;
        }
        Cookie cookieName = new Cookie("name",name);
        resp.addCookie(cookieName);
        Cookie cookiePassword = new Cookie("password",password);
        resp.addCookie(cookiePassword);
        System.out.println("MaxAge"+cookieName.getMaxAge());
        System.out.println("MaxAge"+cookiePassword.getMaxAge());
        printWriter.println("你输入的值是:");
        printWriter.println(name+"     "+password);
       printWriter.println("<form  action=\"/RegistrationWithCookie\" method=\"post\">");
       printWriter.println("<input type=\"submit\" value=\"提交\"></form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = null;
        String password = null;
        Cookie[] cookiesArr = req.getCookies();
        for(Cookie cookie : cookiesArr)
        {
            if (cookie.getName().equals("name"))
            {
                name=cookie.getValue();
            }
            if (cookie.getName().equals("password"))
            {
                password=cookie.getValue();
            }
        }
        try {
            System.out.println(name);
            pst.setString(1,name);
            pst.setString(2,password);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
