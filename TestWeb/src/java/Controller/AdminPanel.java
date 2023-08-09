/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class AdminPanel extends HttpServlet {

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
            out.println("<title>Servlet AdminPanel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminPanel at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("stu") != null) {
            request.getRequestDispatcher("Student/student.jsp").forward(request, response);
        }
        if (request.getParameter("sub") != null) {
            request.getRequestDispatcher("Subject/subject.jsp").forward(request, response);
        }
        if (request.getParameter("que") != null) {
            request.getRequestDispatcher("Question/question.jsp").forward(request, response);
        }
        if (request.getParameter("gra") != null) {
            request.getRequestDispatcher("Grade/grade.jsp").forward(request, response);
        }
        if (request.getParameter("sendPage") != null) {
            if (request.getParameter("sendPage").equals("1")) {
//                response.sendRedirect("Teacher/teacher.jsp");
                request.getRequestDispatcher("Grade/grade.jsp").forward(request, response);
            } else if (request.getParameter("sendPage").equals("2")) {
//                response.sendRedirect("Student/student.jsp");
                request.getRequestDispatcher("Student/student.jsp").forward(request, response);
            } else if (request.getParameter("sendPage").equals("3")) {
//                response.sendRedirect("Question/question.jsp");
                request.getRequestDispatcher("Question/question.jsp").forward(request, response);
            } else if (request.getParameter("sendPage").equals("4")) {
//                response.sendRedirect("Subject/subject.jsp");
                request.getRequestDispatcher("Subject/subject.jsp").forward(request, response);
            }
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
        String check = request.getParameter("check");
        if (check.equals("Interact with students")) {
            request.getRequestDispatcher("Student/student.jsp").forward(request, response);
        } else if (check.equals("Interact with subjects")) {
            request.getRequestDispatcher("Subject/subject.jsp").forward(request, response);
        } else if (check.equals("Interact with grades")) {
            request.getRequestDispatcher("Grade/grade.jsp").forward(request, response);
        } else if (check.equals("Interact with questions")) {
            request.getRequestDispatcher("Question/question.jsp").forward(request, response);
        }
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
