package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.enums.CarroStatus;
import lombok.Builder;

@Builder
public record CarroResponse(
        Long id,
        CarroStatus status,
        String modelo,
        String marca,
        int ano,
        Aluguel aluguel
) {
}
