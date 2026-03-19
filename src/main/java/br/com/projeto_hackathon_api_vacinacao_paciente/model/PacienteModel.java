package br.com.projeto_hackathon_api_vacinacao_paciente.model;

import java.time.LocalDate;

public class PacienteModel {
    private Long id;
    private String nome;
    private String cpf;
    private Boolean sexo;
    private LocalDate dataNascimento;

    public PacienteModel() {
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

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "PacienteModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
