package com.lluanps.lakeSide_hotel_api.api.dto;

import java.time.LocalDate;

import com.lluanps.lakeSide_hotel_api.domain.model.Quarto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

	private Integer id;

	private LocalDate dataCheckIn;

	private LocalDate dataCheckOut;

	private String hospedeNomeCompleto;
	private String hospedeEmail;
	private Integer numDeHospedeAdultos;
	private Integer numDeHospedeCrianca;
	private Integer quantidadeTotalHospede;

	private String codigoDeConfirmacao;

	private Quarto quarto;

	public ReservaDTO(Integer id, LocalDate dataCheckIn, LocalDate dataCheckOut, String codigoDeConfirmacao) {
		this.id = id;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		this.codigoDeConfirmacao = codigoDeConfirmacao;
	}
	
}
