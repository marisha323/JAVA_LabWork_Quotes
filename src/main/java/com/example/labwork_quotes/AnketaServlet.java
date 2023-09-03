package com.example.labwork_quotes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "anketa-servlet", value = "/anketa-servlet")
public class AnketaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String name=request.getParameter("full_name");
//        String phone= request.getParameter("phone");
//        String email=request.getParameter("email");
//        String age=request.getParameter("age");
//        String gender = request.getParameter("gender");
//        String subscribe = request.getParameter("subscribe");
//        response.setContentType("text/html;charset=UTF-8");
//
//        // Виводимо отримані дані користувача
//        response.getWriter().println("<html><head><title>Анкета</title></head><body>");
//        response.getWriter().println("<h1>Отримана інформація з анкети:</h1>");
//        response.getWriter().println("<p>ПІП: " + name + "</p>");
//        response.getWriter().println("<p>Телефон: " + phone + "</p>");
//        response.getWriter().println("<p>Email: " + email + "</p>");
//        response.getWriter().println("<p>Вік: " + age + "</p>");
//        response.getWriter().println("<p>Стать: " + gender + "</p>");
//        if (subscribe != null && subscribe.equals("yes")) {
//            response.getWriter().println("<p>Ви підписалися на нашу розсилку</p>");
//        } else {
//            response.getWriter().println("<p>Ви не підписалися на нашу розсилку</p>");
//        }
//
//        response.getWriter().println("</body></html>");

        String fullName = request.getParameter("full_name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String gender = request.getParameter("gender");
        String subscribe = request.getParameter("subscribe");

        // Перевірка введених даних
        boolean isValid = true;
        String errorMessage = "";

        if (fullName == null || fullName.isEmpty()) {
            isValid = false;
            errorMessage += "Поле 'ПІБ' є обов'язковим.<br>";
        }

        if (phone == null || phone.isEmpty()) {
            isValid = false;
            errorMessage += "Поле 'Телефон' є обов'язковим.<br>";
        }

        if (email == null || email.isEmpty() || !isValidEmail(email)) {
            isValid = false;
            errorMessage += "Поле 'Email' є обов'язковим та повинно бути валідним електронним адресом.<br>";
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 0) {
                isValid = false;
                errorMessage += "Поле 'Вік' повинно бути додатнім числом.<br>";
            }
        } catch (NumberFormatException e) {
            isValid = false;
            errorMessage += "Поле 'Вік' повинно бути числом.<br>";
        }

        // Встановлюємо тип відповіді на HTML
        response.setContentType("text/html;charset=UTF-8");

        // Виводимо результати перевірки
        response.getWriter().println("<html><head><title>Анкета</title></head><body>");
        if (isValid) {
            response.getWriter().println("<h1>Дякуємо за заповнення анкети:</h1>");
            response.getWriter().println("<p>ПІБ: " + fullName + "</p>");
            response.getWriter().println("<p>Телефон: " + phone + "</p>");
            response.getWriter().println("<p>Email: " + email + "</p>");
            response.getWriter().println("<p>Вік: " + age + "</p>");
            response.getWriter().println("<p>Стать: " + gender + "</p>");
            if (subscribe != null && subscribe.equals("yes")) {
                response.getWriter().println("<p>Ви підписалися на нашу розсилку</p>");
            } else {
                response.getWriter().println("<p>Ви не підписалися на нашу розсилку</p>");
            }
        } else {
            response.getWriter().println("<h1>Помилка заповнення анкети:</h1>");
            response.getWriter().println("<p>" + errorMessage + "</p>");
        }

        response.getWriter().println("</body></html>");

    }
    private boolean isValidEmail(String email) {
        // Проста перевірка формату електронної адреси
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
