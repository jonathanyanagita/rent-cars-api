package br.gov.sp.fatec.domain.request;

import lombok.Builder;

import java.util.Date;

@Builder
public record AluguelRequest(Date dataInicio, Date dataFim, Double valor) {}
