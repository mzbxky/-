package com.fc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
    public static void main(String[] args){
        // 提取资源
        Connection connection = null;
        Statement statement = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 准备参数
            String url = "jdbc:mysql://localhost:3306/root1" +
                    "?useSSL=false&useUnicode=true" +
                    "&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "mzb5201314";

            // 获取连接
            connection = DriverManager.getConnection(url, username, password);

            // 获取搬运工对象
            statement = connection.createStatement();

            // 准备sql语句
            String sql = "insert into student(id,name, age) VALUES (7,'小灰灰', 20)";

            // 执行sql语句
            // 获取受影响的行数
            int affectedRows = statement.executeUpdate(sql);

            System.out.println("受影响的行数：" + affectedRows);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
