package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Aluguel;
import lombok.Builder;

@Builder
public record ClienteResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        Aluguel aluguel
) {
}
