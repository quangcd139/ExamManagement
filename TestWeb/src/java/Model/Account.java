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

/**
 *
 * @author TLC
 */
public class Account {

    private String userName, password;

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        connect();
    }

    public Account() {
        connect();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean checkAccount() {
        try {

            String strSelect = "select * from account where "
                    + "userName = ? and password = ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, userName);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
//            SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkAccount " + e.getMessage());
        }
        return false;
    }

}
