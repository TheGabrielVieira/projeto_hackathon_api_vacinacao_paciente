package br.com.projeto_hackathon_api_vacinacao_paciente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.DoseModel;


public interface DoseRepository extends JpaRepository<DoseModel, Long> {

    //Utilizado no endpoint 4 de Estatistica - contagem de doses com idade recomendada maior que X meses
    int countByIdadeRecomendadaAplicacaoGreaterThan(int meses);

    //Utilizado nos endpoints 2 e 3 de Estatistica - busca doses com idade recomendada menor ou igual a X meses
    List<DoseModel> findByIdadeRecomendadaAplicacaoLessThanEqual(int meses);

    //Utilizado no ednpoint 2 de Estatistica - buscae doses com idade recomendada igual a X meses
    List<DoseModel> findByIdadeRecomendadaAplicacao(int meses);
}
