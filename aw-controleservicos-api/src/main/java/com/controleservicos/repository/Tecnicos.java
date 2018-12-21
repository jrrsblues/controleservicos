package com.controleservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleservicos.model.Tecnico;

public interface Tecnicos extends JpaRepository<Tecnico, Long> {

}
