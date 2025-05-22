package com.senai.ecommerce.controllers;

import com.senai.ecommerce.dto.PagamentoDTO;
import com.senai.ecommerce.services.PagamentoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/{pedidoId}")
    public ResponseEntity<?> inserirPagamento(@PathVariable Long pedidoId) {
        try {
            PagamentoDTO pagamentoDTO = pagamentoService.inserirPagamento(pedidoId);
            return ResponseEntity.ok(pagamentoDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
