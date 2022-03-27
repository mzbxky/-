package com.fc.test;

import com.fc.bean.Student;
import com.fc.util.JDBCUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo8 {
    @Test
    public void testAdd() {
        String sql = "insert into student(id,name,age)values(10,'小啊啊啊啊啊',18)";

        //insert into student(id,name,age)VALUES(7,'小灰灰',20)

        int affectedRows = JDBCUtil.update(sql);

        System.out.println("受影响的行数：" + affectedRows);
    }

    @Test
    public void testUpdate() {
        String sql = "update student set name = '丸子龙' where id = 1";

        int affectedRows = JDBCUtil.update(sql);

        System.out.println("受影响的行数：" + affectedRows);
    }

    @Test
    public void testDelete() {
        String sql = "delete from student where id = 10";

        int affectedRows = JDBCUtil.update(sql);

        System.out.println("受影响的行数：" + affectedRows);
    }

    @Test
    public void testQueryOne() {
        String sql = "select * from student where id = 24";

        ResultSet resultSet = JDBCUtil.query(sql);

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                byte age = resultSet.getByte("age");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                String info = resultSet.getString("info");

                Student student = new Student(id, name, age);

                System.out.println(student);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet);
        }
    }

    @Test
    public void testQueryAll() {
        String sql = "select * from student";

        ResultSet resultSet = JDBCUtil.query(sql);

        List<Student> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                byte age = resultSet.getByte("age");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                String info = resultSet.getString("info");

                Student student = new Student(id, name, age);

                list.add(student);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet);
        }

        for (Student student : list) {
            System.out.println(student);
        }
    }

}
