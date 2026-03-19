package br.com.projeto_hackathon_api_vacinacao_paciente.controller;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.PacienteModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public PacienteModel cadastrar(@RequestBody PacienteModel paciente) {
        return service.cadastrar(paciente);
    }

    @GetMapping("/consultar")
    public List<PacienteModel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/consultar/{id}")
    public PacienteModel buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public PacienteModel atualizar(@PathVariable Long id, @RequestBody PacienteModel paciente) {
        return service.atualizar(id, paciente);
    }

    @DeleteMapping("/excluir/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
