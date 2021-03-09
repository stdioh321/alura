package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void deveriaCarregarCursoPorNome() {
        String nome = "HTML 5";
        Curso c1 = new Curso();
        c1.setNome(nome);
        c1.setCategoria("Programacao");
        testEntityManager.persist(c1);
        testEntityManager.flush();
        Curso curso = cursoRepository.findByNomeIgnoreCase(nome.toLowerCase());
        Assert.assertNotNull(cursoRepository.findByNomeIgnoreCase(nome));
        Assert.assertEquals(nome, curso.getNome());
//        throw new RuntimeException("ERRADO");
    }

    @Test
    public void doSomething(){
        System.out.println("COUNT: " + cursoRepository.count());
    }

}
