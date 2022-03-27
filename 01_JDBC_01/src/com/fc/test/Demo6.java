package com.fc.test;

import com.fc.bean.Student;

import java.sql.*;

public class Demo6 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 准备参数
            String url = "jdbc:mysql://localhost:3306/" +
                    "root1?useSSL=false&useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "mzb5201314";

            // 获取连接
            connection = DriverManager.getConnection(url, username, password);

            // 获取搬运工对象
            statement = connection.createStatement();

            // 准备sql
            String sql = "select * from student where id = 2";

            // 执行sql获取结果集对象
            resultSet = statement.executeQuery(sql);

            Student student = null;

            // 如果还有下一行数据
            while (resultSet.next()) {
                // 根据指定的列名获取对应的参数
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                byte age = resultSet.getByte("age");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                String info = resultSet.getString("info");

                student = new Student(id, name, age);
            }

            System.out.println(student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
