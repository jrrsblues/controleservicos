package com.controleservicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleservicos.model.Site;

public interface Sites extends JpaRepository<Site, Long> {

}
