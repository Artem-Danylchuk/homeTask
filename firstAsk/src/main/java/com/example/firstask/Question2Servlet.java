package com.example.firstask;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(name = "Question2", urlPatterns = "/answer2")
public class Question2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String answer = request.getParameter("question2");
        if (answer.equals("yes")) {
            Stats.answer1Question2.incrementAndGet();
        } else if (answer.equals("no")) {
            Stats.answer2Question2.incrementAndGet();
        }

        request.setAttribute("answer1Question1", Stats.answer1Question1);
        request.setAttribute("answer2Question1", Stats.answer2Question1);
        request.setAttribute("answer1Question2", Stats.answer1Question2);
        request.setAttribute("answer2Question2", Stats.answer2Question2);

        request.getRequestDispatcher("/stats.jsp").forward(request, response);
    }
}