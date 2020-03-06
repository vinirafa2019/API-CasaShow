package com.projeto.principal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class ItensCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@ManyToOne
	private Evento even;
	
	@ManyToOne
	private Compra compra;

	@ApiModelProperty(example ="1")
	@JsonInclude(Include.NON_NULL)
	private int quantidade=0;
	
	@ApiModelProperty(example ="200,00")
	@JsonInclude(Include.NON_NULL)
	private float valorunitario;

	@ApiModelProperty(example ="200,00")
	@JsonInclude(Include.NON_NULL)
	private double Valortotal;
	
	public double getValortotal() {
		return Valortotal;
	}
	public void setValortotal(double valortotal) {
		Valortotal = valortotal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Evento getEven() {
		return even;
	}
	public void setEven(Evento even) {
		this.even = even;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValorunitario() {
		return valorunitario;
	}
	public void setValorunitario(float f) {
		this.valorunitario = f;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItensCompra other = (ItensCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
