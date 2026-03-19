package br.com.projeto_hackathon_api_vacinacao_paciente.dto;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.Sexo;

import java.time.LocalDate;

public class PacienteRequestDTO {

    private String nome;
    private String cpf;
    private Sexo sexo;
    private LocalDate dataNascimento;

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
