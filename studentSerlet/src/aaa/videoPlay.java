package aaa;

import aaa.SetJDBC.InitMysql;
import aaa.entity.Danmu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class videoPlay extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("videoPlay.jsp") ;
        try {
            Connection conn = InitMysql.getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from danmu";
            ResultSet rs = st.executeQuery(sql);
            List<Danmu> danmuList = new ArrayList<Danmu>();
            while (rs.next()) {
                String name = rs.getString("userName");
                String content = rs.getString("content");
                Danmu danmu = new Danmu();
                danmu.setName(name);
                danmu.setContent(content);
                danmuList.add(danmu);
            }
            req.setAttribute("danmus", danmuList);
            System.out.println("4566666");
            resp.getWriter().write("videoPlay.jsp");
            dispatcher.forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = req.getRequestDispatcher("videoPlay.jsp") ;
//        try{
//            Connection conn = InitMysql.getConnection();
//            Statement st = conn.createStatement();
//            String sql = "select * from danmu";
//            ResultSet rs = st.executeQuery(sql);
//            List<Danmu> danmuList = new ArrayList<Danmu>();
//            while (rs.next())
//            {
//                String name = rs.getString("userName");
//                String content = rs.getString("content");
//                Danmu danmu = new Danmu();
//                danmu.setName(name);
//                danmu.setContent(content);
//                danmuList.add(danmu);
//            }
//            req.setAttribute("danmus",danmuList);
//            System.out.println("4566666");
//            dispatcher.forward(req,resp);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//}
