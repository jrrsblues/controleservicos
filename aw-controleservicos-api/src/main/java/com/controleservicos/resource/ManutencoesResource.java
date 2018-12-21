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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleservicos.model.Manutencao;
import com.controleservicos.repository.Manutencoes;
import com.controleservicos.service.AcionamentoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/manutencoes")
public class ManutencoesResource {
	
	@Autowired
	Manutencoes manutencoes;
	
	@PersistenceContext
	private EntityManager em;

	@GetMapping("/{ba}")
	@SuppressWarnings("unchecked")
	public  List<Manutencao> listarmanutencaoporba(@PathVariable long ba){
		AcionamentoService acionamentoService = new AcionamentoService();
		TypedQuery<Manutencao> query =
			      em.createQuery("SELECT c FROM Manutencao c where c.ba='" + ba + "' order by c.id desc" + 
			      		"", Manutencao.class);
			  List<Manutencao> results = query.getResultList();
			  for(int i = 0; i < results.size(); i++){
				  if(results.get(i).getDatachegadanosite()!=null) {
					results.get(i).setDatachegadanosite(acionamentoService.retornadataatualretorno(results.get(i).getDatachegadanosite())); 
				  }
				  if(results.get(i).getDatahorastatus()!=null) {
					results.get(i).setDatahorastatus(acionamentoService.retornadataatualretorno(results.get(i).getDatahorastatus())); 
				  }
				  if(results.get(i).getDatasaidadosite()!=null) {
					results.get(i).setDatasaidadosite(acionamentoService.retornadataatualretorno(results.get(i).getDatasaidadosite())); 
				  }
			  }
			  return results;
	}
	
	@PostMapping
	public Manutencao manipularManutencao(@RequestBody @Valid Manutencao manutencao) {
		//Se status alterou, Criar nova linha em manutencao
		AcionamentoService acionamentoService = new AcionamentoService();
		Manutencao manutencaostatus = new Manutencao();
		manutencaostatus = manutencoes.findById(manutencao.getId()).get();
		if((!(manutencaostatus.getStatus().equals(manutencao.getStatus())))||!(manutencaostatus.getTecnico().equals(manutencao.getTecnico()))) {
			 manutencao.setId(0);
			 manutencao.setDatahorastatus(acionamentoService.retornadataatual());
			 if(manutencao.getStatus().equals("Em andamento")) {
				manutencao.setDatachegadanosite(acionamentoService.retornadataatual(manutencao.getDatachegadanosite())); 
			 }
			 if(manutencao.getStatus().equals("Suspensa")) {
				manutencao.setDatachegadanosite(acionamentoService.retornadataatual(manutencao.getDatachegadanosite())); 
				manutencao.setDatasaidadosite(acionamentoService.retornadataatual(manutencao.getDatasaidadosite())); 
			 }
			 if(manutencao.getStatus().equals("Finalizada")) {
				manutencao.setDatachegadanosite(acionamentoService.retornadataatual(manutencao.getDatachegadanosite())); 
				manutencao.setDatasaidadosite(acionamentoService.retornadataatual(manutencao.getDatasaidadosite())); 
			 }
			 manutencoes.save(manutencao);
		 }else {
			 manutencoes.save(manutencao);
		}
		return manutencao;
	}
}
