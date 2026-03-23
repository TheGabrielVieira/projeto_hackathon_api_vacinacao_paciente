package br.com.projeto_hackathon_api_vacinacao_paciente.repository;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.VacinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VacinaRepository extends JpaRepository<VacinaModel, Long> {

    List<VacinaModel> findByPublicoAlvo(VacinaModel.PublicoAlvo publicoAlvo);

}
