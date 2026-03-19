package br.com.projeto_hackathon_api_vacinacao_paciente.service;

import br.com.projeto_hackathon_api_vacinacao_paciente.dto.PacienteRequestDTO;
import br.com.projeto_hackathon_api_vacinacao_paciente.dto.PacienteResponseDTO;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.PacienteModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    private PacienteModel toEntity(PacienteRequestDTO dto) {
        PacienteModel paciente = new PacienteModel();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setSexo(dto.getSexo());
        paciente.setDataNascimento(dto.getDataNascimento());
        return paciente;
    }

    private PacienteResponseDTO toDTO(PacienteModel paciente) {
        return new PacienteResponseDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getSexo(),
                paciente.getDataNascimento()
        );
    }

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public PacienteModel cadastrar(PacienteModel paciente) {
        // regra de negócio
        if (repository.findByCpf(paciente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }

        return repository.save(paciente);
    }

    public List<PacienteModel> listarTodos() {
        return repository.findAll();
    }

    public PacienteModel buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public PacienteModel atualizar(Long id, PacienteModel paciente) {
        PacienteModel existente = buscarPorId(id);

        existente.setNome(paciente.getNome());
        existente.setCpf(paciente.getCpf());
        existente.setSexo(paciente.getSexo());
        existente.setDataNascimento(paciente.getDataNascimento());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
