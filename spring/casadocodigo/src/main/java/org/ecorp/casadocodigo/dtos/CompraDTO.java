package org.ecorp.casadocodigo.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CompraDTO {

  private DetalheCompradorDTO comprador;
  private DetalhesCompraDTO pedido;

  public CompraDTO() {}

  @JsonCreator
  public CompraDTO(DetalheCompradorDTO comprador, DetalhesCompraDTO pedido) {
    this.comprador = comprador;
    this.pedido = pedido;
  }

  /**
   * @return the comprador
   */
  public DetalheCompradorDTO getComprador() {
    return comprador;
  }

  /**
   * @return the pedido
   */
  public DetalhesCompraDTO getPedido() {
    return pedido;
  }



}
