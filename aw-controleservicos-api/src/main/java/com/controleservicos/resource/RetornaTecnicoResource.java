package com.controleservicos.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@RequestMapping("/retornartecnico")
public class RetornaTecnicoResource {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	Tecnicos tecnicos;
	
	@GetMapping("/{uf}")
	@SuppressWarnings("unchecked")
	public List<Tecnico> listartecnicoporuf(@PathVariable String uf){
		//Query query = em.createQuery("Select c.uf, c.nomeusual FROM Tecnico c GROUP BY c.uf, c.nomeusual "
				//+ "HAVING c.uf = '" + uf + "'");
		//List<Tecnico> list = query.getResultList();
		//for(int i =0; i<list.size(); i++){
            //System.out.println("Universo: "+list.get(i).getUf());
        //}
		//for (Tecnico c : list) {
		      //System.out.println(c.getNomeusual());
		//}
		//return tecnicos.findAll();
		TypedQuery<Tecnico> query =
			      em.createQuery("SELECT c FROM Tecnico c where c.uf='" + uf + "'", Tecnico.class);
		      //Query query = em.createQuery("SELECT c.uf FROM Tecnico c", Tecnico.class);
			  List<Tecnico> results = query.getResultList();
			  return results;
	}
}
