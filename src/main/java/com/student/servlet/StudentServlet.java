package com.student.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class StudentServlet extends HttpServlet {
    private static final String URL = "jdbc:postgresql://localhost:5432/studentdb";
    private static final String USER = "mansi";          // your DB user
    private static final String PASSWORD = "mansi0210"; // your DB password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        int age = Integer.parseInt(request.getParameter("age"));
        String fathername = request.getParameter("fathername");
        String mothername = request.getParameter("mothername");
        float twelfth_percentage = Float.parseFloat(request.getParameter("twelfth_percentage"));
        String address = request.getParameter("address");

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String sql = "INSERT INTO student(name,email,course,age,fathername,mothername,twelfth_percentage,address) VALUES (?,?,?,?,?,?,?,?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, course);
                    ps.setInt(4, age);
                    ps.setString(5, fathername);
                    ps.setString(6, mothername);
                    ps.setFloat(7, twelfth_percentage);
                    ps.setString(8, address);
                    ps.executeUpdate();
                }
            }
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
