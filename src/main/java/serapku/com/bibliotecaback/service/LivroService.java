package serapku.com.bibliotecaback.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serapku.com.bibliotecaback.model.Livro;
import serapku.com.bibliotecaback.model.LivroListagemDTO;
import serapku.com.bibliotecaback.repository.LivroRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<LivroListagemDTO> listar() {
        return this.livroRepository.findAll().stream().map(LivroListagemDTO::new).toList();
    }

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        return optionalLivro.orElse(null);
    }

    @Transactional
    public Livro salvarLivro(Livro livro) {
        validarAutor(livro.getAutor());
        return livroRepository.save(livro);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    @Transactional
    public Livro atualizarLivro(Livro livro) {
        validarAutor(livro.getAutor());
        return livroRepository.save(livro);
    }

    public List<Livro> buscarPorCategoria(String categoria) {
        return livroRepository.findByCategoria(categoria);
    }
    public List<LivroListagemDTO> getLivroPorAutor(String autor) {
        List<Livro> livrosPesquisados = this.livroRepository.findByAutor(autor);
        return livrosPesquisados.stream()
                .map(LivroListagemDTO::new)
                .collect(Collectors.toList());
    }

    private void validarAutor(String autor) {
        if (autor == null || autor.length() < 3) {
            throw new AutorInvalidaException("O autor do livro nao existe!");
        }
    }
}
