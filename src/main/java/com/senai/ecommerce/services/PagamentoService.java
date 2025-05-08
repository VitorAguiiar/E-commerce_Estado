package com.senai.ecommerce.services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.PagamentoDTO;
import com.senai.ecommerce.entities.Pagamento;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;
import com.senai.ecommerce.repositories.PagamentoRepository;
import com.senai.ecommerce.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public PagamentoDTO inserirPagamento(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        if (pedido.getStatus() == StatusDoPedido.CANCELADO) {
            throw new IllegalArgumentException("Pedido cancelado, não é possível realizar o pagamento.");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(Instant.now());
        pagamento.setPedido(pedido);

        pagamentoRepository.save(pagamento);

        pedido.setStatus(StatusDoPedido.PAGO);
        pedidoRepository.save(pedido);

        return new PagamentoDTO(
                pagamento.getId(),
                pagamento.getMomento(),
                pedido.getId(),
                pedido.getStatus().name()
        );
    }
}
