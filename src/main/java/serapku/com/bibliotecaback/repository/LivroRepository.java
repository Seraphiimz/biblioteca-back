package serapku.com.bibliotecaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serapku.com.bibliotecaback.model.Livro;

import java.util.List;
import java.util.Optional;


public interface LivroRepository extends JpaRepository<Livro,Long> {

    public List<Livro> findAll ();
    public Livro findByAutorAndTitulo(String autor, String titulo);
    public Optional<Livro> findById(Long id);
    public List<Livro> findByAutor(String autor);
    public List<Livro> findByCategoria(String categoria);

}
