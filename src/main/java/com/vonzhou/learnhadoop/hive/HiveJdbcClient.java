package com.vonzhou.learnhadoop.hive;

import java.sql.*;

/**
 * 参考 http://hadooptutorial.info/hive-jdbc-client-example/
 * Created by vonzhou on 16/9/5.
 */
public class HiveJdbcClient {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");

        Statement stmt = con.createStatement();
        String tableName = "u1_data";
        ResultSet rs = stmt.executeQuery("select count(*) from " + tableName);
        if(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}
