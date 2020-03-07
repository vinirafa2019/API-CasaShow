//package com.projeto.principal.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//
//import io.swagger.annotations.ApiModelProperty;
//
//
//@Entity
//public class Compra implements Serializable{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//
//
//	public Compra() {
//		super(); 
//	}
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne
//	private  Usuarios usuario;
//	
//	@ApiModelProperty(example ="Jose Da Silva")
//	@JsonInclude(Include.NON_NULL)
//	public Usuarios getUsuario() {
//		return usuario;
//	}
//	public void setUsuario(Usuarios usuario) {
//		this.usuario = usuario;
//	}
//	@ApiModelProperty(example ="Cartao de Debito")
//	@JsonInclude(Include.NON_NULL)
//	private String formaPagamento; 
//	
//	public String getFormaPagamento() {
//		return formaPagamento;
//	}
//	public void setFormaPagamento(String formaPagamento) {
//		this.formaPagamento = formaPagamento;
//	}	
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Compra other = (Compra) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//}
