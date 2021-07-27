package br.alura.servlet.dao;

import br.alura.servlet.model.Empresa;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class EmpresaDao {
    public static List<Empresa> empresas
            = new ArrayList<>();

    static {
        var data = new Date();
        empresas.addAll(Arrays
                .asList(
                        new Empresa(UUID.randomUUID().toString(), "Caelum", data),
                        new Empresa(UUID.randomUUID().toString(), "Alura", data)
                )
        );
    }


    public List<Empresa> getAll() {
        return empresas;
    }

    public Empresa get(String id) {
        if (id == null) id = "";
        id = id.trim();
        String finalId = id;
        return empresas.stream().filter(e1 -> {
            boolean res = finalId.equals(e1.getId());
            return res;
        }).findFirst().orElse(null);
    }

    public Empresa add(Empresa emp) {
        empresas.add(emp);
        return emp;
    }

    public Empresa update(String id, Empresa emp) {
        if (StringUtils.isAnyBlank(id)) id = "";
        else id = id.trim();

        var currEmp = this.get(id);

        if (currEmp == null) return null;

        empresas.set(empresas.indexOf(currEmp), emp);
        return emp;
    }

    public boolean remove(String id) {
        if (StringUtils.isBlank(id)) id = "";
        else id = id.trim();
        String finalId = id;
        return empresas.removeIf(emp -> emp.getId().equals(finalId));
    }
}
