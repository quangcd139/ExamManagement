/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Grade {

    private String subjectId, studentId, studentName, mark;
    private Date dateSubmit;

    public Grade(String subjectId, String studentId, String studentName, String mark, Date dateSubmit) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.mark = mark;
        this.dateSubmit = dateSubmit;
        connect();
    }

    public Grade() {
        connect();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(Date dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

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

    public ArrayList<Grade> listAllGradeByStudent(String studentId) {
        ArrayList<Grade> list = new ArrayList<>();
        try {

            String strSelect = "SELECT g.StudentID,SubjectID, "
                    + "StudentName,[time],mark FROM \n"
                    + "Grade g join Students s on g.StudentID=s.StudentID \n"
                    + "where g.StudentID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            rs = pstm.executeQuery();
            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                //String subjectId, studentId, studentName, mark
                String subjectId = rs.getString(2);
                String studentName = rs.getString(3);
                Date dateSubmmit = rs.getDate(4);
                String mark = rs.getString(5);
                sf.format(dateSubmmit);
                Grade g = new Grade(subjectId, studentId, studentName, mark, dateSubmmit);
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println("listAllGradeByStudent " + e.getMessage());
        }

        return list;
    }

    public ArrayList<Grade> listAllGradeBySubject(String subjectId) {
        ArrayList<Grade> list = new ArrayList<>();
        try {

            String strSelect = "SELECT g.StudentID,SubjectID, "
                    + "StudentName,[time],mark FROM \n"
                    + "Grade g join Students s on g.StudentID=s.StudentID \n"
                    + "where g.SubjectID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectId);
            rs = pstm.executeQuery();
            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                String studentId = rs.getString(1);
                String studentName = rs.getString(3);
                Date dateSubmmit = rs.getDate(4);
                String mark = rs.getString(5);
                sf.format(dateSubmmit);
                Grade g = new Grade(subjectId, studentId, studentName, mark, dateSubmmit);
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println("listAllGradeBySubject " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Grade> listAllGrade() {
        ArrayList<Grade> list = new ArrayList<>();
        try {

            String strSelect = "SELECT g.StudentID,SubjectID, "
                    + "StudentName,[time],mark FROM \n"
                    + "Grade g join Students s on g.StudentID=s.StudentID order by subjectId";

            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
//            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                String studentId = rs.getString(1);
                String subjectId = rs.getString(2);
                String studentName = rs.getString(3);
                Date dateSubmmit = rs.getDate(4);
                String mark = rs.getString(5);
//                sf.format(dateSubmmit);
                Grade g = new Grade(subjectId, studentId, studentName, mark, dateSubmmit);
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println("listAllGrade " + e.getMessage());
        }

        return list;
    }

    public boolean addGrade() {
        try {
            String strSelect = "insert into grade (SubjectID,StudentID,Mark,time) \n"
                    + "values (?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectId);
            pstm.setString(2, studentId);
            pstm.setString(3, mark);
            pstm.setDate(4, dateSubmit);
            pstm.execute();

            return true;
        } catch (Exception e) {
            System.out.println("addGrade " + e.getMessage());
            return false;
        }

    }

    public ArrayList<Grade> listBySubjectId(String subjectId) {
        ArrayList<Grade> list = new ArrayList<>();
        try {

            String strSelect = "SELECT g.StudentID,SubjectID, "
                    + "StudentName,[time],mark FROM \n"
                    + "Grade g join Students s on g.StudentID=s.StudentID where subjectId=?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectId);
            rs = pstm.executeQuery();
//            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                String studentId = rs.getString(1);
                String studentName = rs.getString(3);
                Date dateSubmmit = rs.getDate(4);
                String mark = rs.getString(5);
//                sf.format(dateSubmmit);
                Grade g = new Grade(subjectId, studentId, studentName, mark, dateSubmmit);
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println("listBySubjectId " + e.getMessage());
        }

        return list;
    }

    public ArrayList<Grade> listByStudentId(String studentId) {
        ArrayList<Grade> list = new ArrayList<>();
        try {

            String strSelect = "SELECT g.StudentID,SubjectID, "
                    + "StudentName,[time],mark FROM \n"
                    + "Grade g join Students s on g.StudentID=s.StudentID where g.studentId=?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            rs = pstm.executeQuery();
//            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                String subjectId = rs.getString(2);
                String studentName = rs.getString(3);
                Date dateSubmmit = rs.getDate(4);
                String mark = rs.getString(5);
//                sf.format(dateSubmmit);
                Grade g = new Grade(subjectId, studentId, studentName, mark, dateSubmmit);
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println("listByStudentId " + e.getMessage());
        }

        return list;
    }

    public void getGradeByStudentId() {
        try {

            String strSelect = "select * from Grade where StudentID=? and SubjectID=? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            pstm.setString(2, subjectId);
            rs = pstm.executeQuery();
//            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                mark = rs.getString(4);
                dateSubmit = rs.getDate(5);
            }
        } catch (Exception e) {
            System.out.println("getGradeByStudentId " + e.getMessage());
        }
    }

    public boolean update() {
        try {

            String strSelect = "update Grade set Mark=? ,time=?\n"
                    + "where StudentID=? and SubjectID=? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, mark);
            pstm.setDate(2, dateSubmit);
            pstm.setString(3, studentId);
            pstm.setString(4, subjectId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("update " + e.getMessage());
        }
        return false;
    }

    public boolean delete(String studentId, String subjectId) {
        try {

            String strSelect = "delete Grade where StudentID=? and SubjectID=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, studentId);
            pstm.setString(2, subjectId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("delete " + e.getMessage());
        }
        return false;
    }

    

}
