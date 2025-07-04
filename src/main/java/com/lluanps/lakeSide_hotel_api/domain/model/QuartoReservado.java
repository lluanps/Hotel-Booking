package com.lluanps.lakeSide_hotel_api.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class QuartoReservado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "data_check_in")
	private LocalDate dataCheckIn;

	@Column(name = "data_check_out")
	private LocalDate dataCheckOut;

	private String hospedeNomeCompleto;
	private String hospedeEmail;
	private Integer numDeHospedeAdultos;
	private Integer numDeHospedeCrianca;
	private Integer quantidadeTotalHospede;
	
	private String codigoDeConfirmacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quarto_Id")
	private Quarto quarto;
	
	public void calculaTotalHospedes() {
		this.quantidadeTotalHospede = this.numDeHospedeAdultos + numDeHospedeCrianca;
	}

	public void setNumDeHospedeAdultos(Integer numDeHospedeAdultos) {
		this.numDeHospedeAdultos = numDeHospedeAdultos;
		calculaTotalHospedes();
	}

	public void setNumDeHospedeCrianca(Integer numDeHospedeCrianca) {
		this.numDeHospedeCrianca = numDeHospedeCrianca;
		calculaTotalHospedes();
	}

	public void setCodigoDeConfirmacao(String codigoDeConfirmacao) {
		this.codigoDeConfirmacao = codigoDeConfirmacao;
	}
	
}
