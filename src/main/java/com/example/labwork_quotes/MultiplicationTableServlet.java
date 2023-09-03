package com.example.labwork_quotes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "table", value = "/mult-table")
public class MultiplicationTableServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String numberParam=request.getParameter("number");
        response.getWriter().write("<html><head><title>Multiplication Table</title></head><body>");
        response.getWriter().write("<h1>Enter a number to see its multiplication table:</h1>");
        response.getWriter().write("<form method='GET'>");
        response.getWriter().write("Number: <input type='text' name='number'><br>");
        response.getWriter().write("<input type='submit' value='Show Table'>");
        response.getWriter().write("</form>");
        response.getWriter().write("</body></html>");
        if (numberParam!=null&&numberParam.matches("\\d+")){

            int number=Integer.parseInt(numberParam);

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Multiplication Table for ");
            out.println("<table border='1'>");
            for (int i=1;i<=10;i++){
                out.println("<tr><td>"+number+" x "+i+"</td><td>"+number*i+"</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
        }
    }
}
