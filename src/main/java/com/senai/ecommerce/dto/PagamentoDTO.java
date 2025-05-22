package com.senai.ecommerce.dto;

import java.time.Instant;

public class PagamentoDTO {

    private Long id;
    private Instant momento;
    private Long pedidoId;
    private String statusDoPedido;

    public PagamentoDTO(Long id, Instant momento, Long pedidoId, String statusDoPedido) {
        this.id = id;
        this.momento = momento;
        this.pedidoId = pedidoId;
        this.statusDoPedido = statusDoPedido;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(String statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
}
