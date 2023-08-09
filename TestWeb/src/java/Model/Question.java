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
public class Question {

    private String questionId, SubjectId, question, answer;

    public Question() {
        connect();
    }

    public Question(String questionId, String SubjectId, String question, String answer) {
        this.questionId = questionId;
        this.SubjectId = SubjectId;
        this.question = question;
        this.answer = answer;
        connect();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String SubjectId) {
        this.SubjectId = SubjectId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public ArrayList<Question> listAllQuestion() {
        ArrayList<Question> list = new ArrayList<>();
        try {

            String strSelect = "select * from Questions order by subjectId";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String questionId = rs.getString(1);
                String subjectId = rs.getString(2);
                String question = rs.getString(3);
                String answer = rs.getString(4);
                Question q = new Question(questionId, subjectId, question, answer);
                list.add(q);
            }
        } catch (Exception e) {
            System.out.println("List Question " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Question> listBySubjectId(String subjectId) {
        ArrayList<Question> list = new ArrayList<>();
        try {

            String strSelect = "select * from Questions where subjectId=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subjectId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString(1);
//                String subjectId=rs.getString(2);
                String question = rs.getString(3);
                String answer = rs.getString(4);
                Question q = new Question(questionId, subjectId, question, answer);
                list.add(q);
            }
        } catch (Exception e) {
            System.out.println("listBySubjectId " + e.getMessage());
        }

        return list;
    }

    public boolean addQuestion() {
        try {
            String strAdd = "INSERT INTO Questions (QuestionID,SubjectID,descirption,answer)\n"
                    + " VALUES (?,?,?,?)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, questionId);
            pstm.setString(2, SubjectId);
            pstm.setString(3, question);
            pstm.setString(4, answer);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addQuestion: " + e.getMessage());
            return false;
        }

    }

    public boolean getQuestionById(String id) {
        try {
            String strSelect = "select * from Questions where subjectId=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("getQuestionById: " + e.getMessage());

        }
        return false;
    }

    public boolean updateQuestion() {
        try {
            String strUpdate = "update Questions set descirption=? ,answer=? \n"
                    + "where QuestionID=? and SubjectID=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, question);
            pstm.setString(2, answer);
            pstm.setString(3, questionId);
            pstm.setString(4, SubjectId);
            pstm.execute();

            return true;
        } catch (Exception e) {
            System.out.println("updateQuestion: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteQuestion() {
        try {
            String strUpdate = "DELETE FROM Questions WHERE QuestionID=? and subjectId=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, questionId);
            pstm.setString(2, SubjectId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteQuestion: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Question> listAllQuestionOrderBy(String mod) {
        ArrayList<Question> list = new ArrayList<>();
        try {
            String strSelect = "select * from Questions order by QuestionID " + mod;
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString(1);
                String subjectId = rs.getString(2);
                String question = rs.getString(3);
                String answer = rs.getString(4);
                Question q = new Question(questionId, subjectId, question, answer);
                list.add(q);
            }

        } catch (Exception e) {
            System.out.println("listAllQuestionOrderBy " + e.getMessage());
        }

        return list;
    }

    public ArrayList<Question> getAllRandom(int number,String subject) {
        ArrayList<Question> list = new ArrayList<>();
        try {
            String strSelect = "select top "+number +" * from Questions where subjectId=? order by newId()";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, subject);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString(1);
                String subjectId = rs.getString(2);
                String question = rs.getString(3);
                String answer = rs.getString(4);
                Question q = new Question(questionId, subjectId, question, answer);
                list.add(q);
            }

        } catch (Exception e) {
            System.out.println("listAllQuestionOrderBy " + e.getMessage());
        }

        return list;
    }

}
