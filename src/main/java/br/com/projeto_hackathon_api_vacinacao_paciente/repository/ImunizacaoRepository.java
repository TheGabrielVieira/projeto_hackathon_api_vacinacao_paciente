package br.com.projeto_hackathon_api_vacinacao_paciente.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.ImunizacaoModel;

public interface ImunizacaoRepository extends JpaRepository<ImunizacaoModel, Long>{

    void deleteByPacienteId(Long pacienteId);
    
    boolean existsByPacienteId(Long pacienteId);
    
    List<ImunizacaoModel> findByPacienteId(Long pacienteId);

    List<ImunizacaoModel> findByPacienteIdAndDataAplicacaoBetween(
        Long pacienteId,
        LocalDate dtIni,
        LocalDate dtFim
    );

}
