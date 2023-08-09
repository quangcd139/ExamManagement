/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

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
public class SubjectController extends HttpServlet {

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
            out.println("<title>Servlet SubjectController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectController at " + request.getContextPath() + "</h1>");
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
            String subjectId = request.getParameter("id");
            String subjectName = request.getParameter("name");
            String semester = request.getParameter("semester");
            String result = "";
            if (subjectId.isEmpty() || subjectName.isEmpty() || semester.isEmpty()) {
                result = "Enter full information";
            } else {
                try {
                    int ky = Integer.parseInt(semester);
                    Subject s = new Subject(subjectId, subjectName, ky);
                    if (s.addSubject()) {
                        result = "Add subject sucessfully";
                    } else {
                        result = "Add subject failed";
                    }
                } catch (NumberFormatException e) {
                    result = "Semester is an integer";
                }

            }
            request.setAttribute("result", result);
            request.getRequestDispatcher("Subject/AddSubject.jsp").forward(request, response);
        }
        if (request.getParameter("up") != null) {
            String id = request.getParameter("id");
            Subject s = new Subject();
            int x = 0;
            if (s.getSubjectById(id)) {
                x = 1;
                request.setAttribute("result", x);
            } else {
                x = 0;
                request.setAttribute("result", x);
            }
            request.setAttribute("s", s);
            request.getRequestDispatcher("Subject/updateSubject.jsp").forward(request, response);
        }
        if (request.getParameter("update") != null) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String semester = request.getParameter("semester");
            String result = "";
            if (id.isEmpty() || name.isEmpty() || semester.isEmpty()) {
                result = "Enter full information";
            } else {

                if (!semester.matches("[1-9]")) {
                    result = "Please enter an integer from 1 to 9";
                } else {
                    int ky = Integer.parseInt(semester);
                    Subject s = new Subject();
                    s.getSubjectById(id);
                    s.setSubjectId(id);
                    s.setSubjectName(name);
                    s.setSemester(ky);
                    if (s.updateSubject()) {
                        result = "Update subject successfully";
                    } else {
                        result = "Update subject failed";
                    }
                    request.setAttribute("update", result);
                    request.getRequestDispatcher("Subject/updateSubject.jsp").forward(request, response);
                }
            }
        }
        if (request.getParameter("de") != null) {
            String id = request.getParameter("id");
            Subject s = new Subject();
            int x = 0;
            if (s.getSubjectById(id)) {
                x = 1;
                request.setAttribute("x", x);
            } else {
                x = 0;
                request.setAttribute("x", x);
            }

            request.setAttribute("s", s);
            request.getRequestDispatcher("Subject/deleteSubject.jsp").forward(request, response);
        }
        if (request.getParameter("delete") != null) {
            String id = request.getParameter("id");
            String result = "";
            Subject s = new Subject();
            s.getSubjectById(id);
            if (s.deleteSubject()) {
                result = "Delete subject successfully";
            } else {
                result = "Delete subject failed";
            }
            request.setAttribute("delete", result);
            request.getRequestDispatcher("Subject/deleteSubject.jsp").forward(request, response);
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
        if (request.getParameter("check").equals("List all subject")) {
            Subject s = new Subject();
            ArrayList<Subject> listSubject = s.listAllSubject();
            request.setAttribute("listSubject", listSubject);
            request.getRequestDispatcher("Subject/ListSubject.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Add subject")) {
            request.getRequestDispatcher("Subject/AddSubject.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Update subject")) {
            request.getRequestDispatcher("Subject/updateSubject.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Delete subject")) {
            request.getRequestDispatcher("Subject/deleteSubject.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Search")) {
            Subject s = new Subject();
            int check =-1;
            if(s.getSubjectById(request.getParameter("tim"))){
                request.setAttribute("s1", s);
                check=1;
            }
            request.setAttribute("check", check);
            request.setAttribute("err", "Subject not found");
            request.getRequestDispatcher("Subject/subject.jsp").forward(request, response);
        }
    }

}
