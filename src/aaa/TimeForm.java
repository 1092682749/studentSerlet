package aaa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


public class TimeForm extends HttpServlet {
            private static final String CONTENT_TYPE="text/html";
            private Locale[] allLocale=Locale.getAvailableLocales();
            private String[] allTimeZone = TimeZone.getAvailableIDs();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><meta charset=\"UTF-8\"><title></title></head><body>");
        out.println("<h3>Choose locale and zone");
        out.println("<form method=\"post\" action=\"aaa.TimeForm\">");
        out.println("Locale <select size=\"1\" name=\"locale\">");
        for (int i=0; i<allLocale.length; i++)
        {
            out.println("<option value=\""+i+"\">"+allLocale[i].getDisplayName()+"</option>");
            System.out.println(allLocale[i].getDisplayName());
        }
        out.println("</select>");
        out.println("<p>Time Zone<select size=\"1\" name=\"timezone\">");
        for (int i=0;i<allTimeZone.length;i++)
        {
            out.println("<option value=\""+allTimeZone[i]+"\">"+allTimeZone[i]+"</option>");
        }
        out.println("</select>");
        out.println("<p><input type=\"submit\" value=\"Submit\">" );
        out.print("<input type=\"reset\" value=\"Reset\">"+"</p>");
        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        int localeIndex = Integer.parseInt(req.getParameter("locale"));
        String timeZoneID = req.getParameter("timezone");
        out.println("<head><title>Current Time</title></head>");
        out.println("<body>");
        Calendar calendar = new GregorianCalendar(allLocale[localeIndex]);
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,allLocale[localeIndex]);
        dateFormat.setTimeZone(timeZone);
        out.println("current time is "+dateFormat.format(calendar.getTime())+"</p>");
        out.println("</body></html>");
        out.close();
    }
}
