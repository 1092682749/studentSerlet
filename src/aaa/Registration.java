package aaa;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Registration extends HttpServlet {
    PreparedStatement preparedStatement;
    @Override
    public void init() throws ServletException {
        System.out.println(1);
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
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (name.length()==0||password.length()==0)
        {
            printWriter.println("输入有误！");
            return;
        }
        printWriter.println("确认信息：");
        printWriter.println("name"+name);
        printWriter.println("password"+password);
        printWriter.println("<form method=\"post\" action=\"registration\">");
        printWriter.println("<input type=\"hidden\" name=\"name\" value="+name+">");
        printWriter.println("<input type=\"hidden\" name=\"password\" value="+password+">");
        printWriter.println("<input type=\"submit\" value=\"确认\">");
        printWriter.println("</form>");
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        try {
            storeUser(name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        printWriter.println("注册成功！");
    }
    private void initJDBC() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/framedbc?useUnicode=true&characterEncoding=utf8";
//        Connection connection = DriverManager.getConnection(url,"root","root");
        Connection connection = aaa.SetJDBC.InitMysql.getConnection();
        String sql="insert into Admin (name,password) value(?,?)";
        preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    private void storeUser(String name,String password) throws SQLException {
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.executeUpdate();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
        super.service(req, res);
    }
}
