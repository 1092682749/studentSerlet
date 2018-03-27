package aaa;

import aaa.SetJDBC.InitMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer,String> infoMap = new HashMap<Integer, String>();
        try {

            Connection conn = InitMysql.getConnection();
            Statement st = conn.createStatement();
            String sql = "select *from videoInfo";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String info = rs.getString("info");
                infoMap.put(id,info);
            }
            req.setAttribute("videoInfo",infoMap);
            RequestDispatcher dispatcher = req.getRequestDispatcher("indexx.jsp");

            dispatcher.forward(req,resp);
            System.out.println("123");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
