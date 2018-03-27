package aaa;

import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;

public class TestMySql {
    class SqlNullException extends Exception{}
    static  Connection connection=null;
    public StringBuffer readSql() throws IOException, SqlNullException {
        File file = new File("sql/sql.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader in = new BufferedReader(fileReader);
        String str=null;
        StringBuffer stringBuffer=new StringBuffer();
        str=in.readLine();
        while(str!=null)
        {
            stringBuffer.append(str);
            str=in.readLine();
        }
        if (stringBuffer.toString().length()==0)
            throw new SqlNullException();
        return stringBuffer;
    }
    public void execute(String sql) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/framedbc?useUnicode=true&characterEncoding=utf8";
//        String creatTableSql = "CREATE TABLE Students("
//                + "name varchar(20) not null,"
//                + "email varchar(25) not null"
//                + ")charset=utf8;";
        ResultSet set = null;
        connection = DriverManager.getConnection(url, "root", "root");
        Statement statement = connection.createStatement();
        StringTokenizer stringTokenizer = new StringTokenizer(sql, " ");
        String operate = (String) stringTokenizer.nextElement();
        if (operate.equals("select")) {
            set = statement.executeQuery(sql);
            while (set.next()) {
                System.out.print(set.getString("name") + set.getString("email") + "\n");
            }
        } else if (operate.equals("update")||operate.equals("delete")||operate.equals("insert"))
        {
             statement.executeLargeUpdate(sql);
        }
    }
    public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException, SqlNullException {
        TestMySql testMySql = new TestMySql();
        String sql = testMySql.readSql().toString();
        testMySql.execute(sql);
    }
}
