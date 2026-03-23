package br.com.projeto_hackathon_api_vacinacao_paciente.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //
@Table(name = "dose") //
public class DoseModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_dose")
    private Long id;

    // Relacionamento com tabela Vacina
    // @ManyToOne
    // @JoinColumn(name = "id_vacina", nullable=false)
    // private VacinaModel vacina;

    @Column(name = "descricao_dose", nullable=false, length=45)
    private String descricaoDose;

    @Column(name = "idade_recomendada_aplicacao", nullable=false)
    private int idadeRecomendadaAplicacao;

    public DoseModel() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // public VacinaModel getVacina() {
    //     return vacina;
    // }

    // public void setVacina(VacinaModel vacina) {
    //     this.vacina = vacina;
    // }

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

    @Override
    public String toString() {
        return "DoseModel{" +
                "id=" + id +
                // ", vacina=" + vacina +
                ", descricaoDose='" + descricaoDose + '\'' +
                ", idadeRecomendadaAplicacao=" + idadeRecomendadaAplicacao +
                '}';
    }
}
