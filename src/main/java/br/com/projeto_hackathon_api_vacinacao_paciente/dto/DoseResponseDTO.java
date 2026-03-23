package br.com.projeto_hackathon_api_vacinacao_paciente.dto;

public class DoseResponseDTO {

    private Long id;
    private Long idVacina;
    private String descricaoDose;
    private int idadeRecomendadaAplicacao;

    public DoseResponseDTO(Long id, Long idVacina, String descricaoDose, int idadeRecomendadaAplicacao) {
        this.id = id;
        this.idVacina = idVacina;
        this.descricaoDose = descricaoDose;
        this.idadeRecomendadaAplicacao = idadeRecomendadaAplicacao;
    }

    public Long getId() {
        return id;
    }

    public Long getIdVacina() {
        return idVacina;
    }

    public String getDescricaoDose() {
        return descricaoDose;
    }

    public int getIdadeRecomendadaAplicacao() {
        return idadeRecomendadaAplicacao;
    }
}