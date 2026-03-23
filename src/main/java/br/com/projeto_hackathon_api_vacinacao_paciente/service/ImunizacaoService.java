package br.com.projeto_hackathon_api_vacinacao_paciente.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.projeto_hackathon_api_vacinacao_paciente.model.ImunizacaoModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.repository.ImunizacaoRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ImunizacaoService {

    private final ImunizacaoRepository repository;

    public ImunizacaoService(ImunizacaoRepository repository) {
        this.repository = repository;
    }

    public List<ImunizacaoModel> listarTodos(){
        return repository.findAll();
    }

    public ImunizacaoModel cadastrar(ImunizacaoModel imunizacao) {
        return repository.save(imunizacao);
    }

    public ImunizacaoModel buscarPorId(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Imunização não encontrada"));
    }

    public ImunizacaoModel atualizar(Long id, ImunizacaoModel imunizacao) {
        
        ImunizacaoModel existente = buscarPorId(id);

        existente.setDataAplicacao(imunizacao.getDataAplicacao());
        existente.setFabricante(imunizacao.getFabricante());
        existente.setLote(imunizacao.getLote());
        existente.setLocalAplicacao(imunizacao.getLocalAplicacao());
        existente.setProfissionalAplicador(imunizacao.getProfissionalAplicador());

        return repository.save(existente);
    }

    public boolean deletar(Long id){
       
        boolean existeId = repository.existsById(id); 
       
        if(!existeId) {
            throw new RuntimeException("Id da imunização não encontrada: " + id);
        }

        repository.deleteById(id);
        return true;
    }

    public void deletarTodasImunizacoes(){
        repository.deleteAll();
        
    }

    public boolean deletarImunizacoesPorPaciente(Long pacienteId){
        
        if(!repository.existsByPacienteId(pacienteId)){
            return false;
        }

        repository.deleteByPacienteId(pacienteId);
        return true;
    }

    public List<ImunizacaoModel> listarTodasImunizacoesPaciente(Long pacienteId){

        boolean existeIdPaciente = repository.existsByPacienteId(pacienteId);

        if(!existeIdPaciente){
            throw new RuntimeException("Id do paciente não encontrado: " + pacienteId);
        }

        return repository.findByPacienteId(pacienteId);
    }

    public List<ImunizacaoModel> consultarPorPacienteEPeriodo(Long pacienteId, LocalDate dtIni, LocalDate dtFim){
    
        if(dtIni.isAfter(dtFim)){
            throw new RuntimeException("Data inicial maior que data final");
        }

        return repository.findByPacienteIdAndDataAplicacaoBetween(pacienteId, dtIni, dtFim);
    }
}
