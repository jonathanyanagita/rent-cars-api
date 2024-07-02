package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.CarroStatus;

public record CarroUpdateRequest(CarroStatus status, String modelo, String marca, int ano) {}
