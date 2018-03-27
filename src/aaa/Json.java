package aaa;

import aaa.SetJDBC.InitMysql;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.sql.*;

public class Json  {
    public static String getJson() throws SQLException, ClassNotFoundException {
        String lable;
        String value;
       Connection connection = InitMysql.getConnection();
       String sql = "select * from Admin";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        JSONArray jsonArray = new JSONArray();
        while (rs.next())
        {
            JSONObject jsonObject = new JSONObject();
            for (int i=1; i<=metaData.getColumnCount();i++)
            {
                lable = metaData.getColumnName(i);
                value = rs.getString(lable);
                jsonObject.put(lable,value);
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
