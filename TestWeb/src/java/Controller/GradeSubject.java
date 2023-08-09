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
import java.util.ArrayList;

/**
 *
 * @author TLC
 */
public class GradeSubject extends HttpServlet {

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
            out.println("<title>Servlet GradeSubject</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GradeSubject at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("mod") != null) {
            String studentId = request.getParameter("stuId");
            String subjectId = request.getParameter("subId");
            Grade g = new Grade();
            g.setStudentId(studentId);
            g.setSubjectId(subjectId);
            g.getGradeByStudentId();
            request.setAttribute("g", g);
            request.getRequestDispatcher("Grade/updateDetail.jsp").forward(request, response);
        }
        
        if (request.getParameter("modDe") != null) {
            String studentId = request.getParameter("stuId");
            String subjectId = request.getParameter("subId");
            String result = "";
            Grade g = new Grade();
            if (g.delete(studentId, subjectId)) {
                result = "Delete sucessfully";
            } else {
                result = "Delete failed";
            }
            request.setAttribute("delete", result);
            request.getRequestDispatcher("Grade/deleteGrade.jsp").forward(request, response);
        }

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
        if (request.getParameter("update") != null) {
            String subjectId = request.getParameter("subjectId");
            String studentId = request.getParameter("studentId");
            String mark = request.getParameter("mark");
            String time = request.getParameter("time");
            String result = "";
            Grade g = new Grade(subjectId, studentId, studentId, mark, java.sql.Date.valueOf(time));
            if (g.update()) {
                result = "Update successfully";
            } else {
                result = "Update failed";
            }
            request.setAttribute("update", result);
            request.getRequestDispatcher("Grade/updateGrade.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
