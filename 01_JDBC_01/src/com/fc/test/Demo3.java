package com.fc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
    public static void main(String[] args) throws SQLException {
        //提取参数
        Connection connection = null;
        Statement statment = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //准备参数
            String url = "jdbc:mysql://localhost:3306/root1" +
                    "?useSSL=false&useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "mzb5201314";
            //获取连接
            connection = DriverManager.getConnection(url,username,password);
            //获取搬运工对象
            statment = connection.createStatement();
            //准备sql语句
            String sql = "delete from student where id = 2";
            //执行sql语句，并获取被影响的行数
            int affectedRows = statment.executeUpdate(sql);
            System.out.println("受影响的行数"+affectedRows);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭资源
                if(statment!=null){
                    statment.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }

        }
    }
}
