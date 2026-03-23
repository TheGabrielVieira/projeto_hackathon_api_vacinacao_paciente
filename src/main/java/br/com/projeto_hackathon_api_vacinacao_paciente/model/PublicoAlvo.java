package br.com.projeto_hackathon_api_vacinacao_paciente.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PublicoAlvo {

    CRIANÇA("criança"),
    ADOLESCENTE("adolescente"), 
    ADULTO("adulto"), 
    GESTANTE("gestante");

    private String publico;

}
