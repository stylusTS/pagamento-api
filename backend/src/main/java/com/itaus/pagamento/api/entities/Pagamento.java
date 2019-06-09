package com.itaus.pagamento.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.itaus.pagamento.api.dto.PagamentoDto;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 5642494279856830705L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
	private Produto produto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_registro")
	private Date dataRegistro;

	@Column(nullable = false)
	private BigDecimal valor;

	public Pagamento(BigDecimal valor, Produto produto) {
		this.produto = produto;
		this.valor = valor;
		this.dataRegistro = new Date();
	}
	
	public Pagamento() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public PagamentoDto buildDto() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String data = sdf.format(this.dataRegistro);
		
		PagamentoDto to = new PagamentoDto();
		to.produto = this.produto;
		to.valor = this.valor;
		to.data = data;
		return to;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", produto=" + produto + ", dataRegistro=" + dataRegistro + ", valor=" + valor
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (dataRegistro == null) {
			if (other.dataRegistro != null)
				return false;
		} else if (!dataRegistro.equals(other.dataRegistro))
			return false;
		if (id != other.id)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
