package com.example.proyectojee.JDBC;

import com.example.proyectojee.persistence.StudentDAO;
import com.example.proyectojee.persistence.StudentDAOFactoty;
import com.example.proyectojee.persistence.StudentDAOImpl;

import java.io.*;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");
        String code=request.getParameter("code");
        if(code.equalsIgnoreCase("1")){
            StudentDAOImpl student=new StudentDAOImpl();
            ResultSet result= (ResultSet) student.getAllStudents();

            try( PrintWriter out = response.getWriter()){
                out.println( result);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String edad = request.getParameter("edad");
        String discipline = request.getParameter("discipline");
        String mode = request.getParameter("mode");
        String event = request.getParameter("evento");
        String position = request.getParameter("position");
        try( PrintWriter out = response.getWriter()){
            out.println( id +" "+ surname +" "+ name +" "+ edad+" "+discipline+" "+mode+" "+event+" "+position);
        }
    }
    public void destroy() {
    }
}