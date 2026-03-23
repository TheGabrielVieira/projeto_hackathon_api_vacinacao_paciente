/**
 * Usa os models de Imunizacoes, Paciente e Vacina:
 * 
 * - ImunizacaoRepository  →  para consultar vacinas já aplicadas a um paciente;
 * - DoseRepository        →  para consultar doses recomendadas por idade;
 * - PacienteRepository    →  para buscar a data de nascimento do paciente;
 * 
 * 
 */

package br.com.projeto_hackathon_api_vacinacao_paciente.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.DoseModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.ImunizacaoModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.PacienteModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.DoseRepository;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.ImunizacaoRepository;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.PacienteRepository;

@Service
public class EstatisticaService {

    private final DoseRepository doseRepository;
    private final ImunizacaoRepository imunizacaoRepository;
    private final PacienteRepository pacienteRepository;

    public EstatisticaService(DoseRepository doseRepository, ImunizacaoRepository imunizacaoRepository,
            PacienteRepository pacienteRepository) {
        this.doseRepository = doseRepository;
        this.imunizacaoRepository = imunizacaoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // Endpoint 1: quantidade de vacinas aplicadas ao paciente
    public int contarVacinasAplicadas(Long idPaciente) {
        return imunizacaoRepository.findByPacienteId(idPaciente).size();
    }

    // Endpoint 2: quantidade de vacinas aplicáveis no próximo mês
    public int contarProximasImunizacoes(Long idPaciente) {
        PacienteModel paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente não encontrado."));

        // Calcula idade atual em meses e adiciona 1 para o próximo mes
        int idadeAtualEmMeses = Period.between(paciente.getDataNascimento(), 
        LocalDate.now()).getMonths() + Period.between(paciente.getDataNascimento(),
        LocalDate.now()).getYears() * 12;

        int proximoMes = idadeAtualEmMeses + 1;

        // Busca doses já aplicadas ao paciente
        List<DoseModel> dosesProximoMes = doseRepository.findByIdadeRecomendadaAplicacao(proximoMes);

        // Busca doses já aplicadas ao paciente
        List<ImunizacaoModel> imunizacoesAplicadas = imunizacaoRepository.findByPacienteId(idPaciente);

        // Filtra doses do próximo mês que ainda não foram aplicadas
        return (int) dosesProximoMes.stream().filter(
            dose -> imunizacoesAplicadas.stream().noneMatch(
                imunizacao -> imunizacao.getDose().getId().equals(dose.getId()))).count();
    }

    // Endpoint 3: quantidade de vacinas atrasadas
    public int contarImunizacoesAtrasadas(Long idPaciente) {
        PacienteModel paciente = pacienteRepository.findById(idPaciente).orElseThrow(
            () -> new RuntimeException("Paciente não encontrado."));

        // Calcula idade atual em meses
        int idadeAtualEmMeses = Period.between(paciente.getDataNascimento(), 
        LocalDate.now()).getMonths() + Period.between(paciente.getDataNascimento(),
        LocalDate.now()).getYears() * 12;

        // Busca doses que já deveriam ter sido aplicadas
        List<DoseModel> dosesDevidas = doseRepository.findByIdadeRecomendadaAplicacaoLessThanEqual(idadeAtualEmMeses);

        // Busca doses já aplicadas ao paciente
        List<ImunizacaoModel> imunizacoesAplicadas = imunizacaoRepository.findByPacienteId(idPaciente);

        // Filtra doses devidas que ainda não foram aplicadas        
        return (int) dosesDevidas.stream().filter(
            dose -> imunizacoesAplicadas.stream().noneMatch(
                imunizacao -> imunizacao.getDose().getId().equals(dose.getId()))).count();
    }

    // Endpoint 4: quantidade de vacinas acima de uma determinada idade
    public int contarVacinasPorIdadeMaior(int meses) {
        return doseRepository.countByIdadeRecomendadaAplicacaoGreaterThan(meses);
    }
}