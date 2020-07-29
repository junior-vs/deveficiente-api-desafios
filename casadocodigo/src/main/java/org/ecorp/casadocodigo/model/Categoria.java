package org.ecorp.casadocodigo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Categoria {


    @Id
    @SequenceGenerator(name = "CATEGORIA_CATEGORIAID_GENERATOR",
            sequenceName = "CATEGORIA_CATEGORIAID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CATEGORIA_CATEGORIAID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long categoraID;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime instanteAlteracao;

    public Categoria() { //
    }

    public Long getCategoraID() {
        return categoraID;
    }

    public void setCategoraID(final Long categoraID) {
        this.categoraID = categoraID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public LocalDateTime getInstanteAlteracao() {
        return instanteAlteracao;
    }

    public void setInstanteAlteracao(final LocalDateTime instanteAlteracao) {
        this.instanteAlteracao = instanteAlteracao;
    }

    @Override
    public String toString() {
        return String.format("Categoria [categoraID=%s, instanteAlteracao=%s, nome=%s]", categoraID,
                instanteAlteracao, nome);
    }


    
}
