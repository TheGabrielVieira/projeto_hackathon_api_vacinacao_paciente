package br.com.projeto_hackathon_api_vacinacao_paciente.repository;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.PublicoAlvo;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.VacinaModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<VacinaModel, Long> {

    List<VacinaModel> findByPublicoAlvo(PublicoAlvo publicoAlvo);
    List<VacinaModel> findByLimiteAplicacao(Integer meses);
    List<VacinaModel> findByLimiteAplicacaoGreaterThan(Integer meses);


}
