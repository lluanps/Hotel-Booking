package com.lluanps.lakeSide_hotel_api.domain.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "categoria_quarto")
	private String categoriaQuarto;
	
	@Column(name = "preco_quarto")
	private BigDecimal precoQuarto;
	
	@Column(name = "disponivel")
	private boolean isDisponivel = false;
	
	@Lob
	private Blob foto;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
			mappedBy = "quarto")
	@Column(name = "quarto_reservados")
	private List<QuartoReservado> quartoReservados;
	
	public Quarto() {
		this.quartoReservados = new ArrayList<>();// apenas inicialmente para evitar nullpoint
	}
	
	public void addReserva(QuartoReservado quartoReservado) {
		if (quartoReservados == null) {
			quartoReservados = new ArrayList<>();
		}
		quartoReservados.add(quartoReservado);
		quartoReservado.setQuarto(this);
		isDisponivel = true;
		String codigoDaReserva = RandomStringUtils.random(10);
		quartoReservado.setCodigoDeConfirmacao(codigoDaReserva);
	}
	
}
