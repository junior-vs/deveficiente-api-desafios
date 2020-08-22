package org.ecorp.casadocodigo.forms;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonCreator;


public class PedidoRequestForm {

  @NotNull
  @Positive
  public BigDecimal total;

  @NotEmpty
  @NotNull
  @Size(min = 1)
  @Valid
  public List<ItensPedidoFormRequest> itens;

  @JsonCreator
  public PedidoRequestForm(@NotNull @Positive BigDecimal total,
      @Valid @NotEmpty @NotNull @Size(min = 1) List<ItensPedidoFormRequest> itens) {
    this.total = Objects.requireNonNull(total);
    this.itens = Objects.requireNonNull(itens);
  }

  /**
   * @return the total
   */
  public BigDecimal getTotal() {
    return total;
  }

  /**
   * @return the itens
   */
  public List<ItensPedidoFormRequest> getItens() {
    return itens;
  }

  @Override
  public String toString() {
    return String.format("PedidoRequestForm [total=%s, itens=%s]", total, itens);
  }



}
