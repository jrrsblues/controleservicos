package com.controleservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleservicos.model.Acionamento;

public interface Acionamentos extends JpaRepository<Acionamento, Long> {

}
