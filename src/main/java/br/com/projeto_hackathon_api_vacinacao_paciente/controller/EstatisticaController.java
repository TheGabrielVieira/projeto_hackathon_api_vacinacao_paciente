/**
 * EstatisticaController
 *  
 * Quantidade de vacinas aplicadas por paciente;
 * Quantidade de vacinas aplicáveis no próximo mês por paciente;
 * Quantidade de vacinas atrasadas por paciente;
 * Quantidade de vacinas acima de uma determinada idade (em meses);
 * 
 * Os endpoints retornam um número inteiro (`int` ou `Long`) em vez de um objeto. Por exemplo:
 * - GET /estatisticas/imunizacoes/paciente/1  →  retorna  7
 * - GET /estatisticas/imunizacoes_atrasadas/paciente/1  →  retorna  3
 * 
 * Estrutura padrão
 * @GetMapping("path")
 * public String getMethodName(@RequestParam String param) {
 *      return new String();
 * }
 * 
 * A estrutura do Controller será:
 * 
 * endpoint 1: GET /estatisticas/imunizacoes/paciente/{id}
 * → chama service.contarVacinasAplicadas(id)
 * 
 * endpoint 2: GET /estatisticas/proximas_imunizacoes/paciente/{id}
 * → chama service.contarProximasImunizacoes(id)
 * 
 * endpoint 3: GET /estatisticas/imunizacoes_atrasadas/paciente/{id}
 * → chama service.contarImunizacoesAtrasadas(id)
 * 
 * endpoint 4: GET /estatisticas/imunizacoes/idade_maior/{meses}
 * → chama service.contarVacinasPorIdadeMaior(meses)
 */

package br.com.projeto_hackathon_api_vacinacao_paciente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_hackathon_api_vacinacao_paciente.service.EstatisticaService;


@RestController // Mostra para o Spring que essa classe recebe requisições HTTP
@RequestMapping("/estatisticas") // Todas as rotas dessa classe começam com /estatisticas
public class EstatisticaController {
    
    private final EstatisticaService service;

    public EstatisticaController(EstatisticaService service) { // O Spring injeta o Service automaticamente
        this.service = service;
    }

    // endpoint 1: GET /estatisticas/imunizacoes/paciente/{id}
    //   → chama service.contarVacinasAplicadas(id)
    @GetMapping("/imunizacoes/paciente/{id}")
    public int contarVacinasAplicadas(@PathVariable Long id) {
        return service.contarVacinasAplicadas(id);
    }
    
    // endpoint 2: GET /estatisticas/proximas_imunizacoes/paciente/{id}
    //   → chama service.contarProximasImunizacoes(id)
    @GetMapping("/proximas_imunizacoes/paciente/{id}")
    public int contarProximasImunizacoes(@PathVariable Long id) {
        return service.contarProximasImunizacoes(id);
    }

    // endpoint 3: GET /estatisticas/imunizacoes_atrasadas/paciente/{id}
    //   → chama service.contarImunizacoesAtrasadas(id)
    @GetMapping("/imunizacoes_atrasadas/paciente/{id}")
    public int contarImunizacoesAtrasadas(@PathVariable Long id) {
        return service.contarImunizacoesAtrasadas(id);
    }

    // endpoint 4: GET /estatisticas/imunizacoes/idade_maior/{meses}
    //   → chama service.contarVacinasPorIdadeMaior(meses)
    @GetMapping("/imunizacoes/idade_maior/{meses}")
    public int contarVacinasPorIdadeMaior(@PathVariable int meses) {
        return service.contarVacinasPorIdadeMaior(meses);
    }
}