package br.com.projeto_hackathon_api_vacinacao_paciente.model;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vacina")
public class VacinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacina")
    private Long idVacina;

    @Column(name = "nome_vacina")
    private String nomeVacina;

    @Column(name = "desc_vacina")
    private String descVacina;

    @Column(name = "publico_alvo")
    @Convert(converter = PublicoAlvoConverter.class)
    private PublicoAlvo publicoAlvo;

    public VacinaModel() {}

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDescVacina() {
        return descVacina;
    }

    public void setDescVacina(String descVacina) {
        this.descVacina = descVacina;
    }

    public PublicoAlvo getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(PublicoAlvo publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public enum PublicoAlvo {
        CRIANÇA("CRIANÇA"),
        ADOLESCENTE("ADOLESCENTE"),
        ADULTO("ADULTO"),
        GESTANTE("GESTANTE");

        private final String valorBanco;

        PublicoAlvo(String valorBanco) {
            this.valorBanco = valorBanco;
        }

        public String getValorBanco() {
            return valorBanco;
        }

        public static PublicoAlvo fromValor(String valor) {
            for (PublicoAlvo p : PublicoAlvo.values()) {
                if (p.getValorBanco().equals(valor)) {
                    return p;
                }
            }
            throw new IllegalArgumentException("Valor inválido:" + valor);
        }
    }

    @Converter(autoApply = false)
    public static class PublicoAlvoConverter implements AttributeConverter<PublicoAlvo, String> {

        @Override
        public String convertToDatabaseColumn(PublicoAlvo atributo) {
            return atributo == null ? null : atributo.getValorBanco();
        }

        @Override
        public PublicoAlvo convertToEntityAttribute(String valorBanco) {
            return valorBanco == null ? null : PublicoAlvo.fromValor(valorBanco);
        }
    }
}