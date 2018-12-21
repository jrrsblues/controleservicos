package com.controleservicos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Site {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String operadora;
  private String uf;
  private String cidade;
  private String site;
  
  public long getId() {
	return id;
  }
  public void setId(long id) {
	this.id = id;
  }
  public String getOperadora() {
	return operadora;
  }
  public void setOperadora(String operadora) {
	this.operadora = operadora;
  }
  public String getUf() {
	return uf;
  }
  public void setUf(String uf) {
	this.uf = uf;
  }
  public String getCidade() {
	return cidade;
  }
  public void setCidade(String cidade) {
	this.cidade = cidade;
  }
  public String getSite() {
	return site;
  }
  public void setSite(String site) {
	this.site = site;
  }
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Site other = (Site) obj;
	if (id != other.id)
		return false;
	return true;
}
  
  
}
