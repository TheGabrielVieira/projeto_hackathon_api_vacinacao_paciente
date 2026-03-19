package br.com.projeto_hackathon_api_vacinacao_paciente.dto;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.Sexo;

import java.time.LocalDate;

public class PacienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private LocalDate dataNascimento;

    public PacienteResponseDTO() {}

    public PacienteResponseDTO(Long id, String nome, String cpf, Sexo sexo, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
