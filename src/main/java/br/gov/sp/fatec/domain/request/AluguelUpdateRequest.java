package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.AluguelStatus;

import java.util.Date;

public record AluguelUpdateRequest(AluguelStatus status, Date dataFim, Double valor) {}
