package br.com.projeto_hackathon_api_vacinacao_paciente.model;

import java.time.LocalDate;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "imunizacoes")
public class ImunizacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imunizacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "id_dose", nullable = false)
    private PacienteModel dose;
    
    @Column(name = "data_aplicacao", nullable = false)
    private LocalDate dataAplicacao;

    @Column(name = "fabricante", nullable = false, length = 45)
    private String fabricante;

    @Column(name = "lote", length = 45)
    private String lote;

    @Column(name = "local_aplicacao", nullable = false, length = 45)
    private String localAplicacao;

    @Column(name = "profissional_aplicador", nullable = false, length = 45)
    private String profissionalAplicador;

}
