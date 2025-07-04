package com.lluanps.lakeSide_hotel_api.api.dto;

import java.math.BigDecimal;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuartoDTO {
	
	private Integer id;
	
	private String categoriaQuarto;
	
	private BigDecimal precoQuarto;
	
	private boolean isDisponivel = false;
	
	private String foto;
	
	private List<ReservaDTO> quartoReservados;

	public QuartoDTO(Integer id, String categoriaQuarto, BigDecimal precoQuarto) {
		this.id = id;
		this.categoriaQuarto = categoriaQuarto;
		this.precoQuarto = precoQuarto;
	}

	public QuartoDTO(Integer id, String categoriaQuarto, BigDecimal precoQuarto, boolean isDisponivel, byte[] fotoBytes,
			List<ReservaDTO> quartoReservados) {
		this.id = id;
		this.categoriaQuarto = categoriaQuarto;
		this.precoQuarto = precoQuarto;
		this.isDisponivel = isDisponivel;
		this.foto = fotoBytes != null ? Base64.encodeBase64String(fotoBytes) : null;
		this.quartoReservados = quartoReservados;
	}
	
}
