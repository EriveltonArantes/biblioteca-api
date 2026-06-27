package com.bibliotecaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String isbn;
    private Integer anoPublicacao;
    @Column(nullable = false)
    private String genero;
    private Integer exemplares;
    private Integer disponiveis;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Integer getExemplares() { return exemplares; }
    public void setExemplares(Integer exemplares) { this.exemplares = exemplares; }
    public Integer getDisponiveis() { return disponiveis; }
    public void setDisponiveis(Integer disponiveis) { this.disponiveis = disponiveis; }
}
