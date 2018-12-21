package com.controleservicos.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleservicos.model.Acionamento;
import com.controleservicos.model.Manutencao;
import com.controleservicos.repository.Acionamentos;
import com.controleservicos.repository.Manutencoes;
import com.controleservicos.service.AcionamentoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/acionamento")
public class AcionamentoResource {

	@Autowired
	Acionamentos acionamentos;
	
	@Autowired
	AcionamentoService acionamentoService;
	
	@Autowired
	Manutencoes manutencoes;
	
	private Acionamento acionamentoaberto;
	private Manutencao manutencao;
	
	@GetMapping("/{id}")
	public Acionamento getAcionamaneto(@PathVariable Long id){
		return acionamentos.findById(id).get();
	}
	
	@PostMapping
	private Acionamento salvar(@RequestBody @Valid Acionamento acionamento) {
		acionamento.setDatachamado(acionamentoService.retornadataatual());
		acionamentoaberto = new Acionamento();
		acionamentoaberto = acionamentos.save(acionamento);
		manutencao = new Manutencao();
		manutencao.setChave(acionamentoaberto.getId());
		manutencao.setBa(acionamentoaberto.getBa());
		manutencao.setOperador(acionamentoaberto.getOperador());
		manutencao.setUfsite(acionamentoaberto.getUfsite());
		manutencao.setSite(acionamentoaberto.getSite());
		manutencao.setIdtecnico(acionamentoaberto.getIdtecnico());
		manutencao.setUftecnico(acionamentoaberto.getUftecnico());
		manutencao.setTecnico(acionamentoaberto.getTecnico());
		manutencoes.save(manutencao);
		return acionamentoaberto;
	}
}
