package br.com.projeto_hackathon_api_vacinacao_paciente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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


}
