package com.fc.test;


import java.sql.*;

public class Demo5 {
    public static void main(String[] args) {
        //提取资源
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //准备参数
            String url = "jdbc:mysql://localhost:3306/root1?" +
                    "useSSL=false&useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "mzb5201314";
            //获取连接
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        //提取资源
//        Connection connection = null;
//        Statement statment = null;
//        ResultSet resultSet = null;
//        //加载驱动
//        try {
//            //加载驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //准备参数
//            String url = "jdbc:mysql://localhost:3306/" +
//                    "root1?useSSL=false&useUnicode=true&characterEncoding=utf8";
//            String username = "root";
//            String password = "mzb5201314";
//            //获取连接
//            connection = DriverManager.getConnection(url,username,password);
//            //获取搬运工对象
//            statment = connection.createStatement();
//            //准备sql语句
//            String sql = "select*from student where id = 3";
//            //执行sql获取结果对象
//            resultSet = statment.executeQuery(sql);
//            while(resultSet.next()){
//                //根据字段的下标获取获取对应的每一行的值
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                int age = resultSet.getInt(3);
//                Student student = new Student(id,name,age);
//                System.out.println(student);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }finally {
//            //关闭资源
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statment != null) {
//                    statment.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
    }
}
