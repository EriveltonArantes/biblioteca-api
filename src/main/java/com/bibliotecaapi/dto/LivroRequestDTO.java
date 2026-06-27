package com.bibliotecaapi.dto;

import jakarta.validation.constraints.*;

public class LivroRequestDTO {

    @NotNull(message = "AutorId é obrigatório")
    @Positive(message = "AutorId deve ser um ID válido (positivo)")
    private Long autorId;
    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotBlank(message = "isbn não pode estar em branco")
    private String isbn;
    @Min(value = 0, message = "ano publicacao não pode ser negativo")
    @NotNull(message = "ano publicacao não pode ser nulo")
    private Integer anoPublicacao;
    @NotBlank(message = "genero não pode estar em branco")
    private String genero;
    @NotNull(message = "exemplares não pode ser nulo")
    private Integer exemplares;
    @NotNull(message = "disponiveis não pode ser nulo")
    private Integer disponiveis;

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
