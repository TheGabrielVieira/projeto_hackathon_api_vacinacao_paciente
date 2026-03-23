package br.com.projeto_hackathon_api_vacinacao_paciente.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.VacinaModel;

public interface VacinaRepository extends JpaRepository<VacinaModel, Long> {

    List<VacinaModel> findByPublicoAlvo(VacinaModel.PublicoAlvo publicoAlvo);

}
