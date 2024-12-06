package com.example.webapi;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response type to JSON
        response.setContentType("application/json");

        // Read the incoming JSON data from the request
        StringBuilder jsonBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }

        // Convert the JSON string to a JsonObject
        JsonObject jsonObject = Json.createReader(new java.io.StringReader(jsonBuilder.toString())).readObject();

        // Extract fields from the JSON object (example: student name, age, etc.)
        String studentName = jsonObject.getString("name", "");
        int age = jsonObject.getInt("age", 0);

        // Create a response JSON object
        JsonObject responseJson = Json.createObjectBuilder()
                .add("status", "success")
                .add("message", "Student details received")
                .add("name", studentName)
                .add("age", age)
                .build();

        // Send the JSON response back
        try (PrintWriter out = response.getWriter()) {
            out.print(responseJson);
            out.flush();
        }
    }
}
