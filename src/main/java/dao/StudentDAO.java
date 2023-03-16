package dao;

import java.sql.Connection;
import connection.MyConnection;
import model.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> getAll() {
        final String sql = "SELECT * FROM `student`";

        List<Student> studentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthday(rs.getString("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGPA(rs.getDouble("GPA"));
                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
    public static void insert(Student s) {
        final String sql = String.format("INSERT  INTO `student` VALUES ('%s','%s','%d','%s','%s','%s','%s','%s') ",
                s.getId(), s.getFull_name(), s.getGender(), s.getBirthday(), s.getAddress(), s.getPhone(), s.getEmail(),s.getGPA()
        );
        System.out.println(sql);
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Student getById(String id) {
        final String sql = "SELECT * FROM `student` WHERE  `id` = " + "'" + id + "'";
        Student s = null;
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthday(rs.getString("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGPA(rs.getDouble("GPA"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static void update(Student student, String id) {
        Student tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại sinh viên này!");
        }

        final String sql = String.format("UPDATE `student` SET `full_name`='%s',`gender`='%d',`birthday`='%s',`address`='%s',`phone`='%s',`email`='%s',`GPA`='%d' WHERE `id` = '%s'",
                student.getFull_name(), student.getGender(), student.getBirthday(), student.getAddress(), student.getPhone(), student.getEmail(),student.getGPA(), student.getId()
        );
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete(String id) {
        Student s = getById(id);
        if (s == null) {
            throw new RuntimeException("Không tồn tại sinh viên này!");
        }

        final String sql = "DELETE FROM `student` WHERE  `id` = " + "'" + id + "'";
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Student> SortbyGPA() {
        final String sql = "SELECT * FROM `student` ORDER BY `GPA` asc;";

        List<Student> studentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthday(rs.getString("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGPA(rs.getDouble("GPA"));
                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
    public static List<Student> getGirlandSort() {
        final String sql = "SELECT * FROM `student` WHERE `address` = 'HN' and `GPA` > 2.5";

        List<Student> studentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthday(rs.getString("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGPA(rs.getDouble("GPA"));
                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
    public static List<Student> getAllandSort() {
        final String sql = "SELECT * FROM `student` ORDER BY `full_name` asc";

        List<Student> studentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setBirthday(rs.getString("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGPA(rs.getDouble("GPA"));
                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
