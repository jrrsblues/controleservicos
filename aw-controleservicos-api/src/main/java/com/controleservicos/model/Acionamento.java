package com.controleservicos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acionamento {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ba;
	private long idtecnico;
	private String uftecnico;
	private String tecnico;
	private String tecnicostatus;
	private String ufsite;
	private String site;
	private String tipomanutencao;
	private Date datachamado;
	private Date dataacionamento;
	private String operador;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBa() {
		return ba;
	}
	public void setBa(String ba) {
		this.ba = ba;
	}
	public long getIdtecnico() {
		return idtecnico;
	}
	public void setIdtecnico(long idtecnico) {
		this.idtecnico = idtecnico;
	}
	public String getUftecnico() {
		return uftecnico;
	}
	public void setUftecnico(String uftecnico) {
		this.uftecnico = uftecnico;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public String getTecnicostatus() {
		return tecnicostatus;
	}
	public void setTecnicostatus(String tecnicostatus) {
		this.tecnicostatus = tecnicostatus;
	}
	public String getUfsite() {
		return ufsite;
	}
	public void setUfsite(String ufsite) {
		this.ufsite = ufsite;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTipomanutencao() {
		return tipomanutencao;
	}
	public void setTipomanutencao(String tipomanutencao) {
		this.tipomanutencao = tipomanutencao;
	}
	public Date getDatachamado() {
		return datachamado;
	}
	public void setDatachamado(Date datachamado) {
		this.datachamado = datachamado;
	}
	public Date getDataacionamento() {
		return dataacionamento;
	}
	public void setDataacionamento(Date dataacionamento) {
		this.dataacionamento = dataacionamento;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
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
		Acionamento other = (Acionamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
	
}
