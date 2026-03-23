package br.com.projeto_hackathon_api_vacinacao_paciente.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto_hackathon_api_vacinacao_paciente.model.ImunizacaoModel;
import br.com.projeto_hackathon_api_vacinacao_paciente.service.ImunizacaoService;

@RestController
@RequestMapping("/imunizacao")
public class ImunizacaoController {

    private final ImunizacaoService service;

    public ImunizacaoController(ImunizacaoService service) {
        this.service = service;
    }

    @PostMapping("/inserir")
    public ResponseEntity<ImunizacaoModel> cadastrar(@RequestBody ImunizacaoModel imunizacao) {
        
        ImunizacaoModel novaImunizacao = service.cadastrar(imunizacao);

        if(novaImunizacao == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novaImunizacao); 
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<ImunizacaoModel>> listar(){
        
        List<ImunizacaoModel>  lista = service.listarTodos();

        return lista.isEmpty()? ResponseEntity.noContent().build(): 
        ResponseEntity.ok(lista);
    }

     @GetMapping("/consultar/paciente/{id_paciente}")
    public ResponseEntity<List<ImunizacaoModel>> listarImunizacoesPaciente(@PathVariable("id_paciente") Long pacienteId){
        
        List<ImunizacaoModel>  lista = service.listarTodasImunizacoesPaciente(pacienteId);

        return lista.isEmpty()? ResponseEntity.noContent().build(): 
        ResponseEntity.ok(lista);
    }

    @GetMapping("/consultar/{id}")
       public ResponseEntity<ImunizacaoModel> listarImunizacaoPorId(@PathVariable("id") Long id){
        
        ImunizacaoModel  imunizacao = service.buscarPorId(id);

        return ResponseEntity.ok(imunizacao);
    }

    @GetMapping("/consultar/paciente/{id_paciente}/aplicacao/{dt_ini}/{dt_fim}")
    public ResponseEntity<List<ImunizacaoModel>> listarImunizacaoPacientePorPeriodo (
        
        @PathVariable("id_paciente") Long pacienteId,
    
        @PathVariable("dt_ini") 
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dtIni,

        @PathVariable("dt_fim") 
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        
        LocalDate dtFim

    ){
       
        List<ImunizacaoModel> lista = service.consultarPorPacienteEPeriodo(pacienteId, dtIni, dtFim);
       
        
        return lista.isEmpty() 
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(lista);
    }
    
        
    @PutMapping("/alterar/{id}")
    public ResponseEntity<ImunizacaoModel> alterar(@PathVariable("id") Long id, @RequestBody ImunizacaoModel imunizacao) {

        ImunizacaoModel atualizado = service.atualizar(id, imunizacao);

        return atualizado == null ?  ResponseEntity.notFound().build():
         ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> removerImunizacaoPorId(@PathVariable("id") Long id){

        boolean imunizacaoRemovida = service.deletar(id); 

        return imunizacaoRemovida ? ResponseEntity.noContent().build():
        ResponseEntity.notFound().build();
    }

    @DeleteMapping("/excluir/paciente/{id_paciente}")
    public ResponseEntity<Void> removerImunizacaoPorIdDoPaciente(@PathVariable("id_paciente") Long pacienteId){

        boolean imunizacaoRemovida = service.deletarImunizacoesPorPaciente(pacienteId); 

        return imunizacaoRemovida ? ResponseEntity.noContent().build():
        ResponseEntity.notFound().build();
    }


}
