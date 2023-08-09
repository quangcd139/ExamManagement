/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Student;
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
public class StudentController extends HttpServlet {

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
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
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
            String id = request.getParameter("id");
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String result = "";
            if (account.isEmpty() || password.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                result = "Enter full information";
            } else {
                Student s = new Student(id, account, password, name, "", phone);
                if (s.addStudent()) {
                    result = "Add student sucessfully";
                } else {
                    result = "Add student failed";
                }
            }
            request.setAttribute("result", result);
            request.getRequestDispatcher("Student/AddStudent.jsp").forward(request, response);
        }
        if (request.getParameter("up") != null) {
            String id = request.getParameter("id");
            Student s = new Student();
            int x = 0;
            if (s.getStudentById(id)) {
                x = 1;
                request.setAttribute("result", x);
            } else {
                x = 0;
                request.setAttribute("result", x);
            }

            request.setAttribute("s", s);
            request.getRequestDispatcher("Student/updateStudent.jsp").forward(request, response);
        }
        if (request.getParameter("update") != null) {
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String result = "";
            if (id.isEmpty() || password.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                result = "Enter full information";
            } else {
                Student s = new Student();
                s.getStudentById(id);
                s.setPassword(password);
                s.setName(name);
                s.setPhone(phone);
                if (s.updateStudent()) {
                    result = "Update student successfully";
                } else {
                    result = "Update student failed";
                }
                request.setAttribute("update", result);
                request.getRequestDispatcher("Student/updateStudent.jsp").forward(request, response);
            }
        }

        if (request.getParameter("de") != null) {
            String id = request.getParameter("id");
            Student s = new Student();
            int x = 0;
            if (s.getStudentById(id)) {
                x = 1;
                request.setAttribute("x", x);
            } else {
                x = 0;
                request.setAttribute("x", x);
            }

            request.setAttribute("s", s);
            request.getRequestDispatcher("Student/deleteStudent.jsp").forward(request, response);
        }
        if (request.getParameter("delete") != null) {
            String id = request.getParameter("id");
            String result = "";
            Student s = new Student();
            s.getStudentById(id);
            if (s.deleteStudent()) {
                result = "Delete student successfully";
            } else {
                result = "Delete student failed";
            }
            request.setAttribute("delete", result);
            request.getRequestDispatcher("Student/deleteStudent.jsp").forward(request, response);
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
        if (request.getParameter("check").equals("List all student")) {
            Student s = new Student();
            ArrayList<Student> listStudent = s.listAllStudent();
            request.setAttribute("listStudent", listStudent);
            request.getRequestDispatcher("Student/ListStudent.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Add student")) {
            
            request.getRequestDispatcher("Student/AddStudent.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Update student")) {

            request.getRequestDispatcher("Student/updateStudent.jsp").forward(request, response);
        } else if (request.getParameter("check").equals("Delete student")) {
            request.getRequestDispatcher("Student/deleteStudent.jsp").forward(request, response);
        } else if(request.getParameter("check").equals("Search")){
//            String id="";
            Student s = new Student();
            int check =-1;
            if(s.getStudentById(request.getParameter("tim"))){
//                id = request.getParameter("tim");
                request.setAttribute("s1", s);
                check=1;
            }
            request.setAttribute("check", check);
            request.setAttribute("err", "Student not found");
            request.getRequestDispatcher("Student/student.jsp").forward(request, response);
        }

    }

}
