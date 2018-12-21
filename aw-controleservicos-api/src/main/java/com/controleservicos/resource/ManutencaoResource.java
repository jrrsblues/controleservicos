package com.controleservicos.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleservicos.model.Manutencao;
import com.controleservicos.model.Tecnico;
import com.controleservicos.repository.Manutencoes;
import com.controleservicos.service.AcionamentoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/manutencao")
public class ManutencaoResource {
	
	@Autowired
	Manutencoes manutencoes;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	AcionamentoService acionamentoService;
	
	@GetMapping("/{id}")
	@SuppressWarnings("unchecked")
	public Manutencao listarmanutencaoporba(@PathVariable long id){
		Manutencao manutencao = new Manutencao();
		TypedQuery<Manutencao> query =
			      em.createQuery("SELECT c FROM Manutencao c where c.chave=" + id, Manutencao.class);
			  List<Manutencao> results = query.getResultList();
			  for(Manutencao valor : results) {  
				  manutencao = valor;
			  }
			  return manutencao;
	}
	
	@PutMapping
	public Manutencao fecharmanutencao(@RequestBody @Valid Manutencao manutencao) {
		manutencao.setDatahorastatus(acionamentoService.retornadataatual());
		if(manutencao.getDatasaidadosite()!=null) {
		   manutencao.setDatasaidadosite(acionamentoService.retornadataatual(manutencao.getDatasaidadosite()));
		}
		return manutencoes.save(manutencao);
	}

}
