package com.example.labwork_quotes;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.plaf.RootPaneUI;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "game-guess-number", value = "/guess-number")
public class GuessNumberServlet extends HttpServlet {
    private int secretNumber;
    private int attempts;
    @Override
    public void init(){
        Random random=new Random();
        secretNumber=random.nextInt(100)+1;
        attempts=0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<p><a href='/LabWork_Quotes_war_exploded'>НАЗАД</a></p>");
        out.println("<h1>Гра 'Вгадай число'</h1>");

        String userGuess=request.getParameter("guess");
        if (userGuess!=null&&!userGuess.isEmpty()){
            try{
                int guess=Integer.parseInt(userGuess);
                attempts++;
                if (guess<secretNumber){
                    out.println("<p>Число більше, ніж " + guess + ".</p>");
                } else if (guess>secretNumber){
                    out.println("<p>Число менше, ніж " + guess + ".</p>");
                } else {
                    out.println("<p>Вітаємо! Ви вгадали число " + secretNumber + " за " + attempts + " спроб.</p>");
                    out.println("<p><a href='guess-number'>Спробувати ще раз</a></p>");

                    init();
                }
            } catch (NumberFormatException e)
            {
                out.println("<p>Будь ласка, введіть коректне число.</p>");
            }

        }
        out.println("<form method='GET'>");
        out.println("Ваш варіант: <input type='text' name='guess'>");
        out.println("<input type='submit' value='Перевірити'>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
