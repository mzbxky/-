package com.fc.test;

import com.fc.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo9 {
    @Test
    public void testAdd(){
        Connection connection = JDBCUtil.getConnection();
        //提取资源
        PreparedStatement preparedStatement = null;
        String sql = "insert into student(id,name,age) VALUES (?,?,?)";
        try {
            //获取预处理的搬运工对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,10);
            preparedStatement.setString(2,"黑小虎");
            preparedStatement.setInt(3,15);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("受影响的行数"+affectedRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }
    @Test
    public void testDelete(){
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from student where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,9);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("受影响的行数"+affectedRows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }
    @Test
    public void testUpdate(){
        Connection connection = JDBCUtil.getConnection();
        String sql = "update student set age = ? where age = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //将年龄为20的修改为30
            preparedStatement.setInt(1,30);
            preparedStatement.setInt(2,20);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("受影响的行数"+affectedRows);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection);
        }
    }
}
