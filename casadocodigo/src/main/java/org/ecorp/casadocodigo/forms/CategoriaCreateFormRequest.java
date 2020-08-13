package org.ecorp.casadocodigo.forms;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Categoria;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaCreateFormRequest {

  @NotNull
  @NotBlank
  @UniqueValue(domainClass = Categoria.class, fieldName = "categoriaNome")
  private String categoriaNome;

  @JsonCreator
  public CategoriaCreateFormRequest(@NotNull @NotBlank @UniqueValue(domainClass = Categoria.class,
      fieldName = "nome") String categoriaNome) {
    this.categoriaNome = categoriaNome;
  }

  public Categoria map() {
    return new Categoria(null, this.categoriaNome, LocalDateTime.now());
  }

}
