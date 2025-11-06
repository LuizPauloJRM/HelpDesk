package com.helpdesk.erp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.push.Status;

@Entity
@Table(name = "chamado")
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String titulo;
	
	/*Column : Mapeamento de um campo para uma coluna definir o tamanho varchar*/
	@Column(length = 1000)
	private String descricao;

	/* Timestamp: Gravar hora e data*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFechamento;

	/*Enum mapeado na entidade status*/
	@Enumerated(EnumType.STRING)
	private Status status;

	
	@Override
	public String toString() {
		return "Chamado [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}

	/* Relacionamentos */
	/*ManyToOne faz especificação com JPA definir multiplas instancias de entidade relacionamentos*/
	/*Banco de dados relacional*/
	/*Muitos para um ManyToOne*/
	/*JoinColumn especificação da coluna para fazer referencia a cliente*/
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	
	/*Getter e Setter*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
}
