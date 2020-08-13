package org.ecorp.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Livro {

    @Id
    @SequenceGenerator(name = "LIVRO_LIVROID_GENERATOR", sequenceName = "LIVRO_LIVROID_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVRO_LIVROID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long livroID;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String resumo;

    @Column(columnDefinition = "TEXT")
    private String sumario;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer nuPagina;

    @Column(nullable = false, unique = true)
    private String isbn;

    private LocalDate dtPublicacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaid", nullable = false, foreignKey = @ForeignKey(name = "categoriaid_fk"))
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autorid", nullable = false, foreignKey = @ForeignKey(name = "autorid_id"))
    private Autor autor;

    public Livro() { //
    }

    public Long getLivroID() {
        return livroID;
    }

    public void setLivroID(final Long livroID) {
        this.livroID = livroID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(final String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(final String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(final BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNuPagina() {
        return nuPagina;
    }

    public void setNuPagina(final Integer nuPagina) {
        this.nuPagina = nuPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(final LocalDate dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(final Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format(
                "Livro [autor=%s, categoria=%s, dtPublicacao=%s, isbn=%s, livroID=%s, nuPagina=%s, preco=%s, resumo=%s, sumario=%s, titulo=%s]",
                autor, categoria, dtPublicacao, isbn, livroID, nuPagina, preco, resumo, sumario,
                titulo);
    }

    

}
