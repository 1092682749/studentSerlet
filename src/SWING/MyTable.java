package SWING;

import aaa.SetJDBC.InitMysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class MyTable {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        //从数据库查找数据
        Vector<String> vector = new Vector<String>(0);
        Connection conn = InitMysql.getConnection();
        Statement st = conn.createStatement();
        String sql = "select * from acount";
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();



        //顶级容器设置
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(500,600);




        //table设置
        String[] ss= {"a","b"};
        String[][] sss= {{"a","b"},{"aa","bb"}};
        JTable jTable = new JTable(sss,ss);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        table.setShowVerticalLines(true);
        for (int i = 1; i <= metaData.getColumnCount(); i++){
            model.addColumn(metaData.getColumnName(i));
        }
        while (rs.next())
        {
            vector.add(rs.getString(1));
            vector.add(rs.getString(2));
            vector.add(rs.getString(3));
            model.addRow(vector);
            vector.clear();
        }

        //组件RollPanle
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
//        frame.add(scrollPane);
        frame.getContentPane().add(scrollPane);
        System.out.println(table.getColumnCount());
        frame.setVisible(true);
    }
}
