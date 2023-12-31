package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serapku.com.bibliotecaback.model.Livro;
import serapku.com.bibliotecaback.model.LivroListagemDTO;
import serapku.com.bibliotecaback.service.LivroService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    private LivroService LivroService;
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroListagemDTO> listar(@RequestParam(value = "autor", required = false) String autor) {
        if (autor != null && !autor.isBlank()) {
            List<LivroListagemDTO> livrosPesquisados = this.LivroService.getLivroPorAutor(autor);
            if (livrosPesquisados != null && !livrosPesquisados.isEmpty()) {
                return livrosPesquisados;
            }
            return Collections.emptyList();
        }
        return this.livroService.listar();
    }


    @GetMapping
    public List<Livro> listarTodosLivros() {
        return livroService.listarTodosLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscarLivroPorId(id);
    }

    @PostMapping
    public Livro salvarLivro(@RequestBody Livro livro) {
        return livroService.salvarLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        return livroService.atualizarLivro(livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}
