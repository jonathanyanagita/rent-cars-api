package br.gov.sp.fatec.domain.request;

import lombok.Builder;

@Builder
public record CarroRequest(String modelo, String marca, int ano) {}
