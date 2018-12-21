package com.controleservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleservicos.model.Manutencao;

public interface Manutencoes extends JpaRepository<Manutencao, Long> {

}
