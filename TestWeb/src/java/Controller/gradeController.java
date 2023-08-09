/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Grade;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class gradeController extends HttpServlet {

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
            out.println("<title>Servlet gradeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gradeController at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("add") != null) {
            String subjectId = request.getParameter("subjectId");
            String studentId = request.getParameter("studentId");
            String mark = request.getParameter("mark");
            String time = request.getParameter("time");
            String result = "";
            Grade g = new Grade(subjectId, studentId, studentId, mark, java.sql.Date.valueOf(time));
            if (g.addGrade()) {
                result = "Add grade sucessfully";
            } else {
                result = "Add grade failed";
            }
            Subject s =new Subject();
            ArrayList<Subject> list = s.getAllSubject();
            request.setAttribute("list", list);
            request.setAttribute("result", result);
            request.getRequestDispatcher("Grade/AddGrade.jsp").forward(request, response);
        }

        if (request.getParameter("up1") != null) {
            Grade g = new Grade();
            String subjectId = request.getParameter("subjectId");
            ArrayList<Grade> list = g.listBySubjectId(subjectId);
            int x = 0;
            if (list.isEmpty()) {
                x = 0;
                request.setAttribute("result", x);
            } else {
                x = 1;
                request.setAttribute("result", x);
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("Grade/updateGrade.jsp").forward(request, response);
        }
        if (request.getParameter("up2") != null) {
            Grade g = new Grade();
            String studentId = request.getParameter("studentId");
            ArrayList<Grade> list = g.listByStudentId(studentId);
            int x = 0;
            if (list.isEmpty()) {
                x = 0;
                request.setAttribute("result", x);
            } else {
                x = 1;
                request.setAttribute("result", x);
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("Grade/updateGrade.jsp").forward(request, response);
        }
        if (request.getParameter("de1") != null) {
            Grade g = new Grade();
            String subjectId = request.getParameter("subjectId");
            ArrayList<Grade> list = g.listBySubjectId(subjectId);
            int x = 0;
            if (list.isEmpty()) {
                x = 0;
                request.setAttribute("result", x);
            } else {
                x = 1;
                request.setAttribute("result", x);
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("Grade/deleteGrade.jsp").forward(request, response);
        }
        if (request.getParameter("de2") != null) {
            Grade g = new Grade();
            String studentId = request.getParameter("studentId");
            ArrayList<Grade> list = g.listByStudentId(studentId);
            int x = 0;
            if (list.isEmpty()) {
                x = 0;
                request.setAttribute("result", x);
            } else {
                x = 1;
                request.setAttribute("result", x);
            }
            request.setAttribute("list", list);
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
        if (request.getParameter("check").equals("List all grade")) {
            Grade g = new Grade();
            ArrayList<Grade> listGrade = g.listAllGrade();
            request.setAttribute("listGrade", listGrade);
            request.getRequestDispatcher("Grade/ListGrade.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Add grade")) {
            Subject s =new Subject();
            ArrayList<Subject> list = s.getAllSubject();
            request.setAttribute("list", list);
            request.getRequestDispatcher("Grade/AddGrade.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Update grade")) {
            request.getRequestDispatcher("Grade/updateGrade.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Delete grade")) {
            request.getRequestDispatcher("Grade/deleteGrade.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Search")) {
            Grade g = new Grade();
            String stuId = request.getParameter("studentId");
            ArrayList<Grade> listGrade = new ArrayList<>();
            listGrade = g.listByStudentId(stuId);
            if (listGrade.isEmpty()) {
                request.setAttribute("err", "Grade not found");
                request.setAttribute("check", 0);
                request.getRequestDispatcher("Grade/grade.jsp").forward(request, response);
            }else{
                request.setAttribute("listGrade", listGrade);
                request.getRequestDispatcher("Grade/ListGrade.jsp").forward(request, response);
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
