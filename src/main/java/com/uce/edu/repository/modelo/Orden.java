package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orden")
	@SequenceGenerator(name = "seq_orden", sequenceName = "seq_orden", allocationSize = 1)
	@Column(name = "orden_id")
	private Integer id;
	@Column(name = "orden_fecha")
	private LocalDateTime fecha;
	@Column(name = "orden_descripcion")
	private String descripcion;
	@Column(name = "orden_total")
	private BigDecimal total;
	@Column(name = "orden_metodo_pago")
	private String metodoPago;
	

	@ManyToOne
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", total=" + total
				+ ", metodoPago=" + metodoPago + "]";
	}

}
