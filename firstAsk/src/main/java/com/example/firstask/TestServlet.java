package com.example.firstask;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class TestServlet extends HttpServlet {
    static AtomicInteger answer1Question1 = new AtomicInteger(0);
    static AtomicInteger answer2Question1 = new AtomicInteger(0);
    static AtomicInteger answer1Question2 = new AtomicInteger(0);
    static AtomicInteger answer2Question2 = new AtomicInteger(0);
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        String answer = request.getParameter("test");
        if (answer.equals("man")){
            answer1Question1.incrementAndGet();
        }
        else if (answer.equals("female")){
            answer2Question1.incrementAndGet();
        }

        String answer2 = request.getParameter("test2");
        if (answer2.equals("yes")) {
            answer1Question2.incrementAndGet();
        } else if (answer2.equals("no")) {
            answer2Question2.incrementAndGet();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +"answer 1: "+answer1Question1 +" ;" + "</h1>");
        out.println("<h1>" +"answer 2: "+answer2Question1 +" ;" + "</h1>");
        out.println("<h1>" +"Question 2 answer 1: "+answer1Question2 +" ;" + "</h1>");
        out.println("<h1>" +"Question 2 answer 2: "+answer2Question2 +" ;" + "</h1>");
        out.println("</body></html>");

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "hello boy" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}