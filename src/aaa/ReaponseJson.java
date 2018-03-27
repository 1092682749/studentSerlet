package aaa;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ReaponseJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Roll.jsp");
        try {
            req.setAttribute("jsonObject",Json.getJson());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            System.out.println(name+"    "+password);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<p>中奖号码是<em>"+name+"</em></p>");
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        NameValuePair[] data = {
           new NameValuePair("uid","a092682749"),
           new NameValuePair("key","5f0d73358cd2458f9acc"),
           new NameValuePair("smsMob","15238210655"),
           new NameValuePair("smsText","123456")
        };
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getRequestHeaders();
        int status = post.getStatusCode();
        System.out.println("状态码是"+status);
        for (Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        System.out.println(result);
        post.releaseConnection();
    }
}
