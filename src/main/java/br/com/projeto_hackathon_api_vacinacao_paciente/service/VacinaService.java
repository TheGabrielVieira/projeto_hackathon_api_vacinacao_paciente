package br.com.projeto_hackathon_api_vacinacao_paciente.service;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.VacinaModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.VacinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public List<VacinaModel> consultarTodas() {
        return vacinaRepository.findAll();
    }

    public List<VacinaModel> consultarPorPublico(VacinaModel.PublicoAlvo publicoAlvo) {
        return vacinaRepository.findByPublicoAlvo(publicoAlvo);
    }

    // Idade (em meses)
    public List<VacinaModel> consultarPorIdadeMaior(int meses) {
        return vacinaRepository.findAll()
                .stream()
                .filter(vacina -> getIdadeRecomendada(vacina) > meses)
                .collect(Collectors.toList());
    }

    private int getIdadeRecomendada(VacinaModel vacina) {

        switch (vacina.getPublicoAlvo()) {
            case CRIANÇA:
                return 12; // exemplo
            case ADOLESCENTE:
                return 144; // 12 anos
            case ADULTO:
                return 216; // 18 anos
            case GESTANTE:
                return 240; // exemplo
            default:
                return 0;
        }
    }
}
