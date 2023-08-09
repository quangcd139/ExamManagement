/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Question;
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
public class QuestionController extends HttpServlet {

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
            out.println("<title>Servlet QuestionController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionController at " + request.getContextPath() + "</h1>");
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
            String questionId = request.getParameter("questionId");
            String subjectId = request.getParameter("subjectId");
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            String result = "";
            if (questionId.isEmpty() || subjectId.isEmpty() || question.isEmpty() || answer.isEmpty()) {
                result = "Enter full information";
            } else {
                Question s = new Question(questionId, subjectId, question, answer);
                if (s.addQuestion()) {
                    result = "Add question sucessfully";
                } else {
                    result = "Add question failed";
                }
            }
            Subject s =new Subject();
            ArrayList<Subject> list = s.getAllSubject();
            request.setAttribute("list", list);
            request.setAttribute("result", result);
            request.getRequestDispatcher("Question/AddQuestion.jsp").forward(request, response);
        }
        if (request.getParameter("up") != null) {
            String subjectId = request.getParameter("subjectId");
            Question q = new Question();
            ArrayList<Question> list = q.listBySubjectId(subjectId);
            int x = 0;
            if (list.isEmpty()) {
                x = 0;
                request.setAttribute("result", x);
            } else {
                x = 1;
                request.setAttribute("result", x);
            }
            request.setAttribute("list", list);
            request.setAttribute("q", q);
            request.getRequestDispatcher("Question/updateQuestion.jsp").forward(request, response);
        }

        if (request.getParameter("de") != null) {
            String subjectId = request.getParameter("subjectId");
            Question q = new Question();
            ArrayList<Question> list = q.listBySubjectId(subjectId);
            int x = 0;
            if (list.isEmpty()) {
                x = 0;
                request.setAttribute("result", x);
            } else {
                x = 1;
                request.setAttribute("result", x);
            }
            
            request.setAttribute("list", list);
            request.setAttribute("q", q);
            request.getRequestDispatcher("Question/deleteQuestion.jsp").forward(request, response);
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
        if (request.getParameter("check").equals("List all question")) {
            Question s = new Question();
            ArrayList<Question> listQuestion = s.listAllQuestion();
            request.setAttribute("listQuestion", listQuestion);
            request.getRequestDispatcher("Question/ListQuestion.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Add question")) {
            Subject s =new Subject();
            ArrayList<Subject> list = s.getAllSubject();
            request.setAttribute("list", list);
            request.getRequestDispatcher("Question/AddQuestion.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Update question")) {

            request.getRequestDispatcher("Question/updateQuestion.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Delete question")) {
            request.getRequestDispatcher("Question/deleteQuestion.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Search")) {
            Question q = new Question();
            String subjectId = request.getParameter("tim");
            int check = -1;
            if (subjectId.isEmpty() || !q.getQuestionById(subjectId)) {
                check = -1;
            } else {
                check = 1;
                ArrayList<Question> listSubject = q.listBySubjectId(subjectId);

                request.setAttribute("listQuestion", listSubject);
                request.getRequestDispatcher("Question/ListQuestion.jsp").forward(request, response);
            }
            request.setAttribute("check", check);
            request.getRequestDispatcher("Question/question.jsp").forward(request, response);
        }
    }

}
