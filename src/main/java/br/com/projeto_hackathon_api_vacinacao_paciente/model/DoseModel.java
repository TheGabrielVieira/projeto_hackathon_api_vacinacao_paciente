package br.com.projeto_hackathon_api_vacinacao_paciente.model;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "dose")
public class DoseModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dose")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vacina", nullable = false)
    private VacinaModel vacina;

    @Column(name = "descricao_dose", nullable = false, length = 45)
    private String descricao;

    @Column(name = "idade_recomendada_aplicacao", nullable = false)
    private String idadeRecomendacao;

}
