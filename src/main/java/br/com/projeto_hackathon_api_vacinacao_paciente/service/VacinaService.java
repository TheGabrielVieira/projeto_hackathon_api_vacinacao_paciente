package br.com.projeto_hackathon_api_vacinacao_paciente.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.PublicoAlvo;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.VacinaModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.VacinaRepository;

@Service
public class VacinaService {

    private final VacinaRepository repository;

    public VacinaService(VacinaRepository repository) {
        this.repository = repository;
    }

    public List<VacinaModel> listarTodos(){
        return repository.findAll();
    }

    public List<VacinaModel> listarVacinasPraFaixaEtaria(String faixa){

        PublicoAlvo publico;

        try {
            publico = PublicoAlvo.valueOf(faixa.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Faixa etária inválida. Use: CRIANCA, ADOLESCENTE, ADULTO, GESTANTE");
        }

        return repository.findByPublicoAlvo(publico);
    }

    public List<VacinaModel> listarVacinasAcimaIdade(int meses){

        return repository.findByLimiteAplicacaoGreaterThan(meses);
    }





}
