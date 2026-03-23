gpackage br.com.projeto_hackathon_api_vacinacao_paciente.controller;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.VacinaModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.service.VacinaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @GetMapping("/consultar")
    public List<VacinaModel> consultarTodas() {
        return vacinaService.consultarTodas();
    }

    @GetMapping("/consultar/faixa_etaria/{faixa}")
    public List<VacinaModel> consultarPorFaixa(@PathVariable String faixa) {

        VacinaModel.PublicoAlvo publico
                = VacinaModel.PublicoAlvo.fromValor(faixa);

        return vacinaService.consultarPorPublico(publico);
    }

    @GetMapping("/consultar/idade_maior/{meses}")
    public List<VacinaModel> consultarPorIdade(@PathVariable int meses) {
        return vacinaService.consultarPorIdadeMaior(meses);
    }
}
