package com.bibliotecaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private Leitor leitor;
    private java.time.LocalDateTime dataEmprestimo;
    private java.time.LocalDateTime dataDevolucaoPrevista;
    private java.time.LocalDateTime dataDevolucaoReal;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }
    public Leitor getLeitor() { return leitor; }
    public void setLeitor(Leitor leitor) { this.leitor = leitor; }
    public java.time.LocalDateTime getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(java.time.LocalDateTime dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public java.time.LocalDateTime getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(java.time.LocalDateTime dataDevolucaoPrevista) { this.dataDevolucaoPrevista = dataDevolucaoPrevista; }
    public java.time.LocalDateTime getDataDevolucaoReal() { return dataDevolucaoReal; }
    public void setDataDevolucaoReal(java.time.LocalDateTime dataDevolucaoReal) { this.dataDevolucaoReal = dataDevolucaoReal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
