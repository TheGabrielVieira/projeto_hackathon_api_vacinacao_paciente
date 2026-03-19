package br.com.projeto_hackathon_api_vacinacao_paciente.model;

public enum Sexo {
    M,
    F;

    public static Sexo fromString(String value) {
        if (value.equalsIgnoreCase("M") || value.equalsIgnoreCase("Masculino")) {
            return M;
        } else if (value.equalsIgnoreCase("F") || value.equalsIgnoreCase("Feminino")) {
            return F;
        }
        throw new IllegalArgumentException("Sexo inválido");
    }
}
