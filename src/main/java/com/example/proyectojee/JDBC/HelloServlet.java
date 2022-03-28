package com.example.proyectojee.JDBC;

import com.example.proyectojee.logic.Student;
import com.example.proyectojee.persistence.StudentDAO;
import com.example.proyectojee.persistence.StudentDAOFactoty;
import com.example.proyectojee.persistence.StudentDAOImpl;
import com.google.gson.Gson;

import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final StudentDAOFactoty factory = new StudentDAOFactoty();
    private String message;

    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        if (request.getParameter("op").equals("1")) {
            StudentDAOFactoty factory = new StudentDAOFactoty();
            response.setContentType("text/json");
            ArrayList<Student> participants = factory.createStudentDAO().getAllStudents();
            String stAux = gson.toJson(participants);
            try (
                    PrintWriter out = response.getWriter();
            ) {
                out.println(stAux);
            }
        }
        if (request.getParameter("op").equals("2")){

        }
    }


    /**
     * Metodo para agregar participantes al MYSQL ¡no tocar!, por favor me llevo 3 dias.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if para agregar
        if (request.getParameter("op").equals("1")){
            response.setContentType("text/json");
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String edad = request.getParameter("edad");
            String discipline = request.getParameter("discipline");
            String mode = request.getParameter("mode");
            String event = request.getParameter("evento");
            String position = request.getParameter("position");

            Student s = new Student(id, surname,name,edad,mode,discipline,event,position);
            factory.createStudentDAO().addStudent(s);

            try( PrintWriter out = response.getWriter()){
                out.println( id +" "+ surname +" "+ name +" "+ edad+" "+discipline+" "+mode+" "+event+" "+position);
            }
        }
        if (request.getParameter("op").equals("2")){


        }


    }

    public void destroy() {
    }
}