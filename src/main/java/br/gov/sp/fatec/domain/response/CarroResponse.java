package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.enums.CarroStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

public record CarroResponse(
        Long id,
        CarroStatus status,
        String modelo,
        String marca,
        int ano,
        Aluguel aluguel
) {
}
