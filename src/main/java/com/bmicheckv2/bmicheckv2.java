package com.bmicheckv2;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

//@WebServlet("/bmicheckv2")
public class bmicheckv2 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String processedResult = "";
        
        if ((request.getParameter("weight") != "") || (request.getParameter("height") != "")) {
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height")) / 100;
        
        double bmicheck = weight / (height * height);
        bmicheck = Math.floor(bmicheck * 100) / 100;
        String category;
        if (bmicheck < 18.5) category = "Underweight";
        else if (bmicheck < 24.9) category = "Normal weight";
        else if (bmicheck < 29.9) category = "Overweight";
        else category = "Obese";
        
        processedResult = "your BMI: " + bmicheck + ", your category: " + category;
        }
        else 
            {
       processedResult = "Please enter valid weight and height values.";
        }
        
        request.setAttribute("resultMessage", processedResult);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle initial GET request to show index.jsp cleanly
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
