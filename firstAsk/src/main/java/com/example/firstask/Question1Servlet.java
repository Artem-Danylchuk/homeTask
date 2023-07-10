package com.example.firstask;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "Question1", urlPatterns = "/answer1")
public class Question1Servlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Store the submitted data
        String answer = request.getParameter("question1");
        if (answer.equals("man")){
            Stats.answer1Question1.incrementAndGet();
        }
        else if (answer.equals("female")){
            Stats.answer2Question1.incrementAndGet();
        }

        // Redirect to the next question
        response.sendRedirect("/question2.html");
    }

}