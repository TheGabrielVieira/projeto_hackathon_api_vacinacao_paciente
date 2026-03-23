package br.com.projeto_hackathon_api_vacinacao_paciente.dto;

public class DoseRequestDTO {

    private Long idVacina;
    private String descricaoDose;
    private int idadeRecomendadaAplicacao;

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public String getDescricaoDose() {
        return descricaoDose;
    }

    public void setDescricaoDose(String descricaoDose) {
        this.descricaoDose = descricaoDose;
    }

    public int getIdadeRecomendadaAplicacao() {
        return idadeRecomendadaAplicacao;
    }

    public void setIdadeRecomendadaAplicacao(int idadeRecomendadaAplicacao) {
        this.idadeRecomendadaAplicacao = idadeRecomendadaAplicacao;
    }
}