package com.controleservicos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manutencao {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long chave;
	private String ba;
	private String status;
	private long idtecnico;
	private String ufsite;
    private String site;
    private String uftecnico;
    private String tecnico ;
	private String operador;
	private Date datahorastatus;
	private Date datachegadanosite;
	private Date datasaidadosite;
	private String detalhes;
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
	public String getBa() {
		return ba;
	}
	public void setBa(String ba) {
		this.ba = ba;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getIdtecnico() {
		return idtecnico;
	}
	public void setIdtecnico(long idtecnico) {
		this.idtecnico = idtecnico;
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
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public Date getDatahorastatus() {
		return datahorastatus;
	}
	public void setDatahorastatus(Date datahorastatus) {
		this.datahorastatus = datahorastatus;
	}
	public Date getDatachegadanosite() {
		return datachegadanosite;
	}
	public void setDatachegadanosite(Date datachegadanosite) {
		this.datachegadanosite = datachegadanosite;
	}
	public Date getDatasaidadosite() {
		return datasaidadosite;
	}
	public void setDatasaidadosite(Date datasaidadosite) {
		this.datasaidadosite = datasaidadosite;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
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
		Manutencao other = (Manutencao) obj;
		if (id != other.id)
			return false;
		return true;
	}
		
}
