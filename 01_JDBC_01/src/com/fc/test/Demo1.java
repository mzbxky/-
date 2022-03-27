package com.fc.test;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args){
        //提取资源
        Connection connection = null;
       try{
           //加载驱动
       Class.forName("com.mysql.jdbc.Driver");
       //准备参数
           String url = "jdbc:mysql://localhost:3306/root1?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "mzb5201314";
            //获取连接
           connection = DriverManager.getConnection(url,username,password);
           System.out.println(connection);
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }finally {
           //关闭资源
           try{
               if(connection!=null){
                   connection.close();
               }
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
       }
    }
}
