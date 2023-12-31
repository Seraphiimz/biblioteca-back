package serapku.com.bibliotecaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serapku.com.bibliotecaback.model.Categoria;
import serapku.com.bibliotecaback.model.Livro;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Categoria findCategoriaByIdAndLivros(Long id, String livros);

    public Categoria findCategoriaById(Long id);

    public List<Categoria> findAll ();
}
