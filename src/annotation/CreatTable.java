package annotation;

import MyHibernate.Column;
import MyHibernate.Table;
import org.apache.commons.collections.bag.SynchronizedSortedBag;

import javax.swing.text.html.HTMLDocument;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CreatTable {
    public void   creatTable(String str) throws ClassNotFoundException, SQLException {
        Class<?> claz = Class.forName(str);
        List<Column> columnNameList = new ArrayList<Column>();
        MyHibernate.Table tableAnn = claz.getAnnotation(Table.class);
        String tableName = tableAnn.name();
//        String tableName = "wodebiao";
        System.out.println(tableName);
        Field[] fields = claz.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields)
        {
            if (field.isAnnotationPresent(Column.class))
            {
                Column c = field.getAnnotation(Column.class);
                columnNameList.add(c);
            }
        }
        Iterator<Column> iterator = columnNameList.iterator();
//        System.out.println(iterator.next().name());
        String subSql = "";
        while(iterator.hasNext())
        {
            Column c = iterator.next();
            subSql += c.name()+" "+c.type()+"("+c.length()+"), ";
        }
        int i=subSql.lastIndexOf(",");
        subSql= subSql.substring(0,i);
//        subSql = subSql+")";
        String sql = "create table "+tableName+" ( "+subSql+")";
        System.out.println(sql);
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/framedbc";
        String name = "root";
        String pass = "root";
        Connection connection = DriverManager.getConnection(url,name,pass);
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    }
}
