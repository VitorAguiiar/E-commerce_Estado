package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ecommerce.services.RelatorioService;

@RestController
@RequestMapping("relatorios")
public class RelatorioController {

	@Autowired
	RelatorioService relatorioService;
	
	@GetMapping
	public ResponseEntity<String> gerarRelatorioPDF(@RequestParam String caminho) throws Exception  {
		
		relatorioService.gerarRelatorio(caminho);
		
		return ResponseEntity.ok("Relatório gerado com sucesso!" + caminho);
	}
	
}
