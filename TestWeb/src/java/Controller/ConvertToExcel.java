/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Grade;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author TLC
 */
public class ConvertToExcel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConvertToExcel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConvertToExcel at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Grade g = new Grade();
        ArrayList<Grade> listGrade = g.listAllGrade();
        HSSFWorkbook workbook = new HSSFWorkbook();
        // Create a new sheet in the workbook
        Sheet sheet = workbook.createSheet("Data");

        // Create a header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Student ID");
        header.createCell(1).setCellValue("Subject ID");
        header.createCell(2).setCellValue("Student Name");
        header.createCell(3).setCellValue("Time Submit");
        header.createCell(4).setCellValue("Mark");
        // Add some data rows
        for (int i = 1; i <= listGrade.size(); i++) {
            Row row1 = sheet.createRow(i);
            row1.createCell(0).setCellValue(listGrade.get(i-1).getStudentId());
            row1.createCell(1).setCellValue(listGrade.get(i-1).getSubjectId());
            row1.createCell(2).setCellValue(listGrade.get(i-1).getStudentName());
            String date = new SimpleDateFormat("dd-MM-yyyy").format(listGrade.get(i-1).getDateSubmit());
            row1.createCell(3).setCellValue(date);
            row1.createCell(4).setCellValue(listGrade.get(i-1).getMark());
        }

//        Row row2 = sheet.createRow(2);
//        row2.createCell(0).setCellValue("Jane Smith");
//        row2.createCell(1).setCellValue(25);
        // Autosize the columns to fit the data
        for (int i = 1; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }
//        sheet.autoSizeColumn(0);
//        sheet.autoSizeColumn(1);
        // Write the workbook to a file
        FileOutputStream fileOut = new FileOutputStream("D:\\Semester4\\PRJ301\\TestWeb\\Data.xls");
        workbook.write(fileOut);
        fileOut.close();
        // Close the workbook
        workbook.close();
        request.setAttribute("listGrade", listGrade);
        request.setAttribute("err", "export success");
        request.getRequestDispatcher("Grade/ListGrade.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
