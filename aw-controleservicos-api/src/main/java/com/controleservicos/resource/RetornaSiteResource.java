package com.controleservicos.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleservicos.model.Site;
import com.controleservicos.repository.Sites;

@CrossOrigin("*")
@RestController
@RequestMapping("/retornarsite")
public class RetornaSiteResource {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	Sites tecnicos;
	
	@GetMapping("/{uf}")
	@SuppressWarnings("unchecked")
	public List<Site> listarsiteporuf(@PathVariable String uf){
		TypedQuery<Site> query =
			      em.createQuery("SELECT c FROM Site c where c.uf='" + uf + "'", Site.class);
			  List<Site> results = query.getResultList();
			  return results;
	}
}
