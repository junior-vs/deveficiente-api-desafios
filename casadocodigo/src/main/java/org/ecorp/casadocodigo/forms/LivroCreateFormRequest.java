package org.ecorp.casadocodigo.forms;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.ecorp.casadocodigo.model.Autor;
import org.ecorp.casadocodigo.model.Categoria;
import org.ecorp.casadocodigo.model.Livro;
import org.ecorp.casadocodigo.validators.ExistsID;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroCreateFormRequest {

  @NotBlank
  @NotNull
  private String titulo;

  @NotBlank
  @NotNull
  @Size(max = 500)
  private String resumo;

  private String sumario;

  @NotNull
  @Min(20)
  private BigDecimal preco;

  @NotNull
  @Min(20)
  private Integer nuPagina;

  @NotBlank
  @NotNull
  private String isbn;

  @Future
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dtPublicacao;

  @NotNull
  @ExistsID(domainClass = Categoria.class, fieldName = "categoriaID")
  private Long categoriaID;

  @NotNull
  @ExistsID(domainClass = Autor.class, fieldName = "autorID")
  private Long autorID;

  public LivroCreateFormRequest() {
    // Auto-generated constructor stub
  }

  @JsonCreator
  public LivroCreateFormRequest(@NotBlank @NotNull String titulo,
      @NotBlank @NotNull @Size(max = 500) String resumo, String sumario,
      @NotNull @Min(20) BigDecimal preco, @NotNull @Min(20) Integer nuPagina,
      @NotBlank @NotNull String isbn, @Future LocalDate dtPublicacao, @NotNull Long categoriaID,
      @NotNull Long autorID) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.nuPagina = nuPagina;
    this.isbn = isbn;
    this.dtPublicacao = dtPublicacao;
    this.categoriaID = categoriaID;
    this.autorID = autorID;
  }

  /**
   * @return the titulo
   */
  public String getTitulo() {
    return titulo;
  }


  /**
   * @return the resumo
   */
  public String getResumo() {
    return resumo;
  }


  /**
   * @return the sumario
   */
  public String getSumario() {
    return sumario;
  }


  /**
   * @return the preco
   */
  public BigDecimal getPreco() {
    return preco;
  }


  /**
   * @return the nuPagina
   */
  public Integer getNuPagina() {
    return nuPagina;
  }


  /**
   * @return the isbn
   */
  public String getIsbn() {
    return isbn;
  }


  /**
   * @return the dtPublicacao
   */
  public LocalDate getDtPublicacao() {
    return dtPublicacao;
  }


  /**
   * @return the categoriaID
   */
  public Long getCategoriaID() {
    return categoriaID;
  }


  /**
   * @return the autorID
   */
  public Long getAutorID() {
    return autorID;
  }

  public Livro map() {
    Livro livro = new Livro();
    livro.setTitulo(this.titulo);
    livro.setResumo(this.resumo);
    livro.setSumario(this.sumario);
    livro.setPreco(this.preco);
    livro.setNuPagina(this.nuPagina);
    livro.setIsbn(this.isbn);
    livro.setDtPublicacao(this.dtPublicacao);
    return livro;
  }



}