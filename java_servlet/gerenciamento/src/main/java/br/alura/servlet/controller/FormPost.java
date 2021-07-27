package br.alura.servlet.controller;

import br.alura.servlet.dao.EmpresaDao;
import br.alura.servlet.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@WebServlet("/form-post")
public class FormPost extends HttpServlet {
    private EmpresaDao empresaDao;

    public FormPost() {
        this.empresaDao = new EmpresaDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("empresas", empresaDao.getAll());
        req.getSession().removeAttribute("empresa");
        req.getRequestDispatcher("/view/form-post.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var out = resp.getWriter();
        String empresa = req.getParameter("name");
        if (empresa == null) {
            return;
        }
        var emp = new Empresa(UUID.randomUUID().toString(), empresa, new Date());
        empresaDao.add(emp);
        HttpSession session = req.getSession();
        session.setAttribute("empresa", emp);

        resp.sendRedirect("view/empresa-add.jsp");

//        var rd = req.getRequestDispatcher("/view/empresa-add.jsp");
//        req.setAttribute("empresa", emp);
//
//        rd.forward(req, resp);
        System.out.println(emp);
    }
}
