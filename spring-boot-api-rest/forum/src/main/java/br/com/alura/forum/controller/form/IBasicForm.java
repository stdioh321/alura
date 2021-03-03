package br.com.alura.forum.controller.form;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasicForm<ENTITY> {

    public <R extends JpaRepository> ENTITY convert(R respository);

    public ENTITY convert();
}
