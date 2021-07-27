package br.alura.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ola",name = "ola")
public class Ola extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameterMap().forEach((k, v) -> {
            try {
                resp.getWriter().println(k + ": " + String.join(" ", v));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("doGet");
        resp.getWriter().println("doGettttttttttttttttt");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
