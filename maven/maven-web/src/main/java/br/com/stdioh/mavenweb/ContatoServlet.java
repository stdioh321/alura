package br.com.stdioh.mavenweb;

import br.com.caelum.stella.tinytype.CPF;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/contato")
public class ContatoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CPF cpf = new CPF("22222222222");

        var w = resp.getWriter();
        w.write(cpf.getNumeroFormatado());
        w.close();
    }
}