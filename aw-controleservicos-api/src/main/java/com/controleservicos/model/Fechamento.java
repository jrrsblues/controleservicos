package com.controleservicos.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Fechamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long chave;
	private Date dataderesolucao;
	private Date datafechamento;
	private String operador;
	private String solucao;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getChave() {
		return chave;
	}
	public void setChave(long chave) {
		this.chave = chave;
	}
	public Date getDataderesolucao() {
		return dataderesolucao;
	}
	public void setDataderesolucao(Date dataderesolucao) {
		this.dataderesolucao = dataderesolucao;
	}
	public Date getDatafechamento() {
		return datafechamento;
	}
	public void setDatafechamento(Date datafechamento) {
		this.datafechamento = datafechamento;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getSolucao() {
		return solucao;
	}
	public void setSolucao(String solucao) {
		this.solucao = solucao;
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
		Fechamento other = (Fechamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
}
