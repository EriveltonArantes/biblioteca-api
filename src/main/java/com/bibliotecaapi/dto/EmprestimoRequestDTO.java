package com.bibliotecaapi.dto;

import jakarta.validation.constraints.*;

public class EmprestimoRequestDTO {

    @NotNull(message = "LivroId é obrigatório")
    @Positive(message = "LivroId deve ser um ID válido (positivo)")
    private Long livroId;
    @NotNull(message = "LeitorId é obrigatório")
    @Positive(message = "LeitorId deve ser um ID válido (positivo)")
    private Long leitorId;
    @NotNull(message = "data emprestimo não pode ser nulo")
    private java.time.LocalDateTime dataEmprestimo;
    @NotNull(message = "data devolucao prevista não pode ser nulo")
    private java.time.LocalDateTime dataDevolucaoPrevista;
    @NotNull(message = "data devolucao real não pode ser nulo")
    private java.time.LocalDateTime dataDevolucaoReal;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
