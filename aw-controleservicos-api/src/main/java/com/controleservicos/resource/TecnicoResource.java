package com.controleservicos.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleservicos.model.Tecnico;
import com.controleservicos.repository.Tecnicos;


@CrossOrigin("*")
@RestController
@RequestMapping("/tecnico")
public class TecnicoResource {
	
	@Autowired
	Tecnicos tecnicos;
	
	@PostMapping
	public Tecnico cadastrarTecnico(@RequestBody @Valid Tecnico tecnico) {
		return tecnicos.save(tecnico);
	}
	
	@PutMapping
	public Tecnico alterarTecnico(@RequestBody @Valid Tecnico tecnico) {
		return tecnicos.save(tecnico);
	}
	
	@GetMapping
	public List<Tecnico> listar(){
		return tecnicos.findAll();
	}
	
}
