package com.bibliotecaapi.dto;

public class EmprestimoResponseDTO {

    private Long id;
    private Long livroId;
    private Long leitorId;
    private java.time.LocalDateTime dataEmprestimo;
    private java.time.LocalDateTime dataDevolucaoPrevista;
    private java.time.LocalDateTime dataDevolucaoReal;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLivroId() { return livroId; }
    public void setLivroId(Long livroId) { this.livroId = livroId; }
    public Long getLeitorId() { return leitorId; }
    public void setLeitorId(Long leitorId) { this.leitorId = leitorId; }
    public java.time.LocalDateTime getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(java.time.LocalDateTime dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public java.time.LocalDateTime getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(java.time.LocalDateTime dataDevolucaoPrevista) { this.dataDevolucaoPrevista = dataDevolucaoPrevista; }
    public java.time.LocalDateTime getDataDevolucaoReal() { return dataDevolucaoReal; }
    public void setDataDevolucaoReal(java.time.LocalDateTime dataDevolucaoReal) { this.dataDevolucaoReal = dataDevolucaoReal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
