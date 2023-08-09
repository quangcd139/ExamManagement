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

/**
 *
 * @author PC
 */
public class Subject {
    private String subjectId,subjectName;
    private int semester;

    public Subject(String subjectId, String subjectName, int semester) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.semester = semester;
        connect();
    }
    
    
    public Subject() {
        connect();
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
    
    public ArrayList<Subject> listAllSubject() {
        ArrayList<Subject> list = new ArrayList<>();
        try {

            String strSelect = "select * from Subjects ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
//            pstm = cnn.prepareStatement(strSelect);
//            rs = pstm.execute();
            while (rs.next()) {
                String subjectId= rs.getString(1);
                String subjectName= rs.getString(2);
                int semester= rs.getInt(3);
                Subject s = new Subject(subjectId, subjectName,semester);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("List Subject " + e.getMessage());
        }
        return list;
    }
    public boolean addSubject() {
        try {
            String strAdd = "INSERT INTO Subjects (subjectId,subjectName,semester) "
                    + "VALUES (?,?,?);";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, subjectId);
            pstm.setString(2, subjectName);
            pstm.setInt(3, semester);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addSubject: " + e.getMessage());
            return false;
        }
    }
    public boolean getSubjectById(String id) {
        try {
            String strSelect = "select * from Subjects where subjectId=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                this.subjectId = id;
                subjectName = rs.getString(2);
                semester =rs.getInt(3);
                return true;
            }

        } catch (Exception e) {
            System.out.println("getSubjectById: " + e.getMessage());

        }
        return false;
    }
    public boolean updateSubject() {
//        if(checkIdExist(subjectId)){
//            return false;
//        }
        try {
            String strUpdate = "UPDATE Subjects "
                    + "SET  SubjectName=?,Semester=? "
                    + "WHERE subjectId=? ";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, subjectName);
            pstm.setInt(2, semester);
            pstm.setString(3, subjectId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateSubject: " + e.getMessage());
            return false;
        }
        
    }
    private boolean checkIdExist(String id){
        ArrayList<Subject> list= listAllSubject();
        for (Subject s : list) {
            if(s.getSubjectId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteSubject() {
        try {
            String strDelete = "DELETE FROM Subjects WHERE SubjectId=?";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, subjectId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteSubject: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Subject> getAllSubject() {
        ArrayList<Subject> list = new ArrayList<>();
        try {

            String strSelect = "select * from [subjects]";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                subjectId = rs.getString(1);
                subjectName = rs.getString(2);
                semester = rs.getInt(3);
                list.add(new Subject(subjectId, subjectName, semester));
            }
        } catch (Exception e) {
            System.out.println("List Question " + e.getMessage());
        }
        return list;
    }
    
}
