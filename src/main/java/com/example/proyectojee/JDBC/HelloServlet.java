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

/**
 * nombre de la clase y el valor del servlrt
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
/**
 * Clase Servlet extendida de HttpServlet
 */
public class HelloServlet extends HttpServlet {
    private final StudentDAOFactoty factory = new StudentDAOFactoty();
    private String message;

    public void init() throws ServletException {

    }

    /**
     * Metodo doGet para obtener todos los datos
     * @param request Variable que obtine los datos del HHTport
     * @param response Variable que obtiene datso
     * @throws IOException Excepcion por la implementacion del metodo
     */
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
     * @param request variable con informacion revogida del JS
     * @param response variable con informacion revogida del JS
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
            response.setContentType("text/json");
            String id = request.getParameter("code");
            factory.createStudentDAO().delete(id);
        }


    }

    public void destroy() {
    }
}