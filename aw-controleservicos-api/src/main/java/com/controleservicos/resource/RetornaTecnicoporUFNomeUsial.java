package com.controleservicos.resource;

import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleservicos.model.Tecnico;
import com.controleservicos.repository.Tecnicos;

@CrossOrigin("*")
@RestController
@RequestMapping("/retornaridporuftecnico")
public class RetornaTecnicoporUFNomeUsial {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	Tecnicos tecnicos;
	
	@GetMapping("/{uftecnico}")
	@SuppressWarnings("unchecked")
	public List<Tecnico> listartecnicoporuf(@PathVariable String uftecnico){
	    StringTokenizer st = new StringTokenizer(uftecnico,"-");
		TypedQuery<Tecnico> query =
			      em.createQuery("SELECT c FROM Tecnico c where c.uf='" + st.nextToken() + "' and c.nomeusual='" + st.nextToken() +"'", Tecnico.class);
			  List<Tecnico> results = query.getResultList();
			  return results;
	}
}
