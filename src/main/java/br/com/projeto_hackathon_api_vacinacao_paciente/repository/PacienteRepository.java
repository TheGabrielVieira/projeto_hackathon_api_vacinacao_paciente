package br.com.projeto_hackathon_api_vacinacao_paciente.repository;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {

    Optional<PacienteModel> findByCpf(String cpf);
}
