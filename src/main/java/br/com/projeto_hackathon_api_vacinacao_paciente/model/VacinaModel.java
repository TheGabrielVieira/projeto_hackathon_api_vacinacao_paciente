package br.com.projeto_hackathon_api_vacinacao_paciente.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "vacina")
public class VacinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacina")
    private Long id;

    @Column(name = "nome_vacina", nullable = false, length = 50)
    private String nomeVacina;

    @Column(name = "descricao_vacina", nullable = false, length = 200)
    private String descricao;

    @Column(name = "limite_aplicacao", nullable = false)
    private int limiteAplicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "publico_alvo", nullable = false)
    private PublicoAlvo publicoAlvo;

}
