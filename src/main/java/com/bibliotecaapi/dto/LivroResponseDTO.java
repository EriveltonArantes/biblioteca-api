package com.bibliotecaapi.dto;

public class LivroResponseDTO {

    private Long id;
    private Long autorId;
    private String titulo;
    private String isbn;
    private Integer anoPublicacao;
    private String genero;
    private Integer exemplares;
    private Integer disponiveis;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
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
