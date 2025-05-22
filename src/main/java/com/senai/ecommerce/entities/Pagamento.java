package com.senai.ecommerce.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

	@Id
	private Long id;
	

    @Version
    private Integer version;

	private Instant momento;

	@OneToOne
	@MapsId
	private Pedido pedido;

	public Pagamento() {}

	public Pagamento(Pedido pedido, Instant momento) {
		this.pedido = pedido;
		this.id = pedido.getId(); // importante
		this.momento = momento;
	}

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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
		if (pedido != null) {
			this.id = pedido.getId(); // garante sincronização
		}
	}
}