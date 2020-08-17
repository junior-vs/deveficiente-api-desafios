package org.ecorp.casadocodigo.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import org.ecorp.casadocodigo.forms.AutorFormRequest;
import org.ecorp.casadocodigo.forms.CategoriaFormRequest;
import org.ecorp.casadocodigo.model.Livro;

public class LivroDTO {

  private Long livroID;

  private String titulo;

  private String resumo;

  private String sumario;

  private BigDecimal preco;

  private Integer nuPagina;

  private String isbn;

  private LocalDate dtPublicacao;

  private CategoriaDTO categoria;

  private AutorDTO autor;

  public LivroDTO() { //
  }



  public LivroDTO(Livro livro) {
    this.livroID = livro.getLivroID();
    this.titulo = livro.getTitulo();
    this.resumo = livro.getResumo();
    this.sumario = livro.getSumario();
    this.preco = livro.getPreco();
    this.nuPagina = livro.getNuPagina();
    this.isbn = livro.getIsbn();
    this.dtPublicacao = livro.getDtPublicacao();
    this.categoria = new CategoriaDTO(livro.getCategoria());
    this.autor = new AutorDTO(livro.getAutor());
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


  public CategoriaDTO getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaDTO categoria) {
    this.categoria = categoria;
  }

  public AutorDTO getAutor() {
    return autor;
  }

  public void setAutor(AutorDTO autor) {
    this.autor = autor;
  }


  @Override
  public String toString() {
    return String.format(
        "Livro [autor=%s, categoria=%s, dtPublicacao=%s, isbn=%s, livroID=%s, nuPagina=%s, preco=%s, resumo=%s, sumario=%s, titulo=%s]",
        autor, categoria, dtPublicacao, isbn, livroID, nuPagina, preco, resumo, sumario, titulo);
  }



}
