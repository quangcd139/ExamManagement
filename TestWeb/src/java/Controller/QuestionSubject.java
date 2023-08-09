/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Question;
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
public class QuestionSubject extends HttpServlet {
    int count=0;
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
            out.println("<title>Servlet QuestionSubject</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionSubject at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("order") != null) {
//            String count = request.getParameter("count");
//            int cou = Integer.parseInt(count);
            count++;
            Question q = new Question();
            ArrayList<Question> listQuestion =new ArrayList<>();
            if (count % 2 == 0) {
               listQuestion = q.listAllQuestionOrderBy("asc");
            }else{
                listQuestion = q.listAllQuestionOrderBy("desc");
            }
            request.setAttribute("listQuestion", listQuestion);
            request.getRequestDispatcher("Question/ListQuestion.jsp").forward(request, response);
            return;
        }
        Question q = new Question();
        String queId = request.getParameter("queId");
        String subId = request.getParameter("subId");
        ArrayList<Question> list = q.listBySubjectId(subId);
        for (Question q1 : list) {
            if (q1.getQuestionId().equals(queId) && q1.getSubjectId().equals(subId)) {
                q = q1;
            }
        }
        if (request.getParameter("up") != null) {
            request.setAttribute("q", q);
            request.getRequestDispatcher("Question/QuestionDetail.jsp").forward(request, response);
        }
        if (request.getParameter("de") != null) {
            String result = "";
            if (q.deleteQuestion()) {
                result = "Delete question successfully";
            } else {
                result = "Delete question failed";
            }
            list = q.listBySubjectId(subId);

            request.setAttribute("list", list);
            request.setAttribute("result", 1);
            request.setAttribute("delete", result);

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

        String questionId = request.getParameter("questionId");
        String subjectId = request.getParameter("subjectId");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String result = "";
        if (questionId.isEmpty() || subjectId.isEmpty() || question.isEmpty() || answer.isEmpty()) {
            result = "Enter fully information";
        } else {
            Question q = new Question(questionId, subjectId, question, answer);
            if (q.updateQuestion()) {
                result = "Update question sucessfully";
            } else {
                result = "Update question failed";
            }
            ArrayList<Question> listQuestion = q.listAllQuestion();
            request.setAttribute("listQuestion", listQuestion);
            request.setAttribute("update", result);
            request.getRequestDispatcher("Question/ListQuestion.jsp").forward(request, response);
        }
    }

}
