package br.alura.servlet.controller;

import br.alura.servlet.dao.EmpresaDao;
import br.alura.servlet.model.Empresa;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form-edit")
public class FormEdit extends HttpServlet {
    private EmpresaDao empresaDao;

    public FormEdit() {
        this.empresaDao = new EmpresaDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        var empresa = empresaDao.get(id);
        if (id == null || empresa == null) {
            resp.sendRedirect("form-post");
            return;
        }
        req.setAttribute("empresa", empresa);
        req.getRequestDispatcher("/view/form-edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        var empresa = empresaDao.get(id);
        if (StringUtils.isAnyBlank(id, nome) || empresa == null) {
            resp.sendRedirect("form-post");
            return;
        }
        empresa.setNome(nome);
        empresaDao.update(id, empresa);
        resp.sendRedirect("form-post");

    }


}
