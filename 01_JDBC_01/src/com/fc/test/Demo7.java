package com.fc.test;

import com.fc.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo7 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 准备参数
            String url = "jdbc:mysql://localhost:3306/root1?" +
                    "useSSL=false&useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "mzb5201314";

            // 获取连接
            connection = DriverManager.getConnection(url, username, password);

            // 获取搬运工对象
            statement = connection.createStatement();

            // 准备sql语句
            String sql = "select * from student";

            // 执行sql语句获取结果集对象
            resultSet = statement.executeQuery(sql);

            // 准备一个存放学生对象的容器
            List<Student> list = new ArrayList<>();

            // 遍历结果集
            while (resultSet.next()) {
                // 分别获取每一行的数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                byte age = resultSet.getByte("age");


                // 封装到对象中
                Student student = new Student(id, name, age);

                // 将封装好的学生对象放到容器中
                list.add(student);
            }

            // 增强for遍历集合
            for (Student student : list) {
                System.out.println(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
