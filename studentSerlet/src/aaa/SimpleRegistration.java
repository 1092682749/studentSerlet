package aaa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SimpleRegistration extends HttpServlet {
    PreparedStatement preparedStatement;
    @Override
    public void init() throws ServletException {
        try {
            initJDBC();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter printWriter=resp.getWriter();
        String name = req.getParameter("name");
        String email=req.getParameter("email");
        System.out.println(name+"   "+email);
        try {
            storeStudent(name,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printWriter.println("保存成功！");
    }
    public void initJDBC() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/framedbc?useUnicode=true&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url,"root","root");
        String sql = "insert into students (name,email) value(?,?)";
        preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    }
    public void storeStudent(String name,String email) throws SQLException {
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,email);
        preparedStatement.executeUpdate();
    }
}
