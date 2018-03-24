package aaa;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static java.text.DateFormat.LONG;

public class ImageContentWithDrawing extends HttpServlet {
     @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.setContentType("image/gif");
         OutputStream out = response.getOutputStream();
         Image image = new BufferedImage(300,300,BufferedImage.TYPE_INT_ARGB);
         Graphics g = image.getGraphics();
         drawClock(g);
         new Acme.JPM.Encoders.GifEncoder(image,out,true).encode();
         out.close();
     }
     private void drawClock(Graphics g)
     {
         int clockRadius = (int)(Math.min(300,300)*0.7*0.5);
         int xCenter = 300/2;
         int yCenter = 300/2;
         g.setColor(Color.BLACK);
         g.drawOval(xCenter-clockRadius,yCenter-clockRadius,2*clockRadius,2*clockRadius);
         g.drawString("12",xCenter-5,yCenter-clockRadius+12);
         g.drawString("9",xCenter-clockRadius+3,yCenter+5);
         g.drawString("3",xCenter+clockRadius-10,yCenter+3);
         g.drawString("6",xCenter-3,yCenter+clockRadius-3);
         TimeZone timeZone = TimeZone.getDefault();
         GregorianCalendar cal = new GregorianCalendar(timeZone);
         int second = (int)cal.get(GregorianCalendar.SECOND);
         int sLength = (int)(clockRadius*0.9);
         int xSecond = (int)(xCenter+sLength*Math.sin(second*(2*Math.PI/60)));
         int ySecond = (int)(yCenter+sLength*Math.cos(second*(2*Math.PI/60)));
         g.setColor(Color.red);
         g.drawLine(xCenter,yCenter,xSecond,ySecond);
         int minute = (int)cal.get(GregorianCalendar.MINUTE);
         int mLength = (int)(clockRadius*0.75);
         int xMinute = (int)(xCenter+mLength*Math.sin(minute*(2*Math.PI/60)));
         int yMinute = (int)(yCenter+mLength*Math.cos(minute*(2*Math.PI/60)));
         g.setColor(Color.blue);
         g.drawLine(xCenter,yCenter,xMinute,yMinute);
         int hour = (int)cal.get(GregorianCalendar.HOUR);
         int hLength = (int)(clockRadius*0.6);
         int xHour = (int)(xCenter+hLength*Math.sin(hour*(2*Math.PI/60)));
         int yHour = (int)(yCenter+hLength*Math.cos(hour*(2*Math.PI/60)));
         g.setColor(Color.green);
         g.drawLine(xCenter,yCenter,xHour,yHour);
         DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.LONG);
         g.setColor(Color.red);
         String today = dateFormat.format(cal.getTime());
         FontMetrics fm = g.getFontMetrics();
         g.drawString(today,300-fm.stringWidth(today)/2,yCenter+clockRadius+30);

     }
}
