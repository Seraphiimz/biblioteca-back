package serapku.com.bibliotecaback.model;

public record LivroListagemDTO(Long id, String titulo, String autor, String descricao, String categoria) {

    public LivroListagemDTO(Livro livro){
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getDescricao(), livro.getCategoria());
    }
}
