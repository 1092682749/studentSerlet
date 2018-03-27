package aaa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetParametes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String mi = req.getParameter("mi");
        String gender = req.getParameter("fender");
        String major = req.getParameter("major");
        String[] minors = req.getParameterValues("minor");
        String tennis = req.getParameter("tennis");
        String golf = req.getParameter("golf");
        String pingPong = req.getParameter("pingPong");
        String remarks = req.getParameter("remarks");
        printWriter.write(lastName+"_"+firstName+"_"+mi+"_"+gender+"_"+major+"_"+tennis+"_"+golf);
        printWriter.write(pingPong+"_"+remarks);
        for(String i : minors)
            printWriter.write(i+"_");
    }
}
