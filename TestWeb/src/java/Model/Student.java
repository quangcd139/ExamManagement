/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TLC
 */
public class Student {

    private String id, account, password, name, email, phone;

    public Student() {
        connect();
    }

    public Student(String id, String account, String password, String name, String email, String phone) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // khia bao thanh phan xu lys database
    Connection cnn;// ket noi db
    Statement stm;//thuc thi cau lenh sql
    ResultSet rs;//luu tru va xu ly du lieu
    PreparedStatement pstm; // thuc thi cau lenh sql

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {

                System.out.println("Connect sucess");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
    }

    public ArrayList<Student> listAllStudent() {
        ArrayList<Student> list = new ArrayList<>();
        try {

            String strSelect = "select * from Students ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                String email = rs.getString(5);
                String phone = rs.getString(6);
                Student s = new Student(id, account, password, name, email, phone);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("List Student " + e.getMessage());
        }

        return list;
    }

    public boolean addStudent() {
        email = generateEmail();
        try {
            String strAdd = "INSERT INTO Students (StudentID,StudentAccount ,[Password],StudentName "
                    + ",StudentEmail,StudentPhone) "
                    + "VALUES (?,?,?,?,?,?);";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, id);
            pstm.setString(2, account);
            pstm.setString(3, password);
            pstm.setString(4, name);
            pstm.setString(5, email);
            pstm.setString(6, phone);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addStudent: " + e.getMessage());
            return false;
        }

    }

    private String generateEmail() {
        //cao dang quang
        name = name.trim();
        String data[] = name.split(" ");
        String result = data[data.length - 1];
        for (int i = 0; i < data.length - 1; i++) {
            result += data[i].substring(0, 1).toLowerCase();
        }
        result += id + "@fpt.edu.vn";
        return result;
    }

    public boolean getStudentById(String id) {
        try {
            String strSelect = "select * from students where studentID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                account = rs.getString(1);
                this.id = id;
                password = rs.getString(3);
                name = rs.getString(4);
                email = rs.getString(5);
                phone = rs.getString(6);
                return true;
            }

        } catch (Exception e) {
            System.out.println("getStudentById: " + e.getMessage());

        }
        return false;
    }

    public boolean updateStudent() {
        try {
            String strUpdate = "UPDATE Students "
                    + "SET StudentName = ?, [Password] = ?,StudentEmail = ?,StudentPhone=? "
                    + "WHERE StudentID=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, password);
            pstm.setString(3, generateEmail());
            pstm.setString(4, phone);
            pstm.setString(5, id);
            pstm.execute();

            return true;
        } catch (Exception e) {
            System.out.println("updateStudent: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent() {
        try {
            String strUpdate = "DELETE FROM Students WHERE StudentID=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, id);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteStudent: " + e.getMessage());
            return false;
        }
    }

}
