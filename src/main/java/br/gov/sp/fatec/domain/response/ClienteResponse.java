package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Aluguel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

public record ClienteResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        Aluguel aluguel
) {
}
