package br.alura.servlet.controller;

import br.alura.servlet.dao.EmpresaDao;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/form-delete")
public class FormDelete extends HttpServlet {

    private EmpresaDao empresaDao;

    public FormDelete() {
        this.empresaDao = new EmpresaDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        var empresa = empresaDao.get(id);
        if (StringUtils.isBlank(id) || empresa == null) {
            resp.sendRedirect("form-post");
            return;
        }
        boolean isRemoved = empresaDao.remove(id);
        resp.sendRedirect("form-post");
    }
}
