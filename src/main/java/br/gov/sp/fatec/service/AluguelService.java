package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import java.util.List;

public interface AluguelService {
    AluguelResponse save(AluguelRequest aluguelRequest);

    Aluguel findById(Long id);

    List<AluguelResponse> findAll();

    void updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest);


    void deleteById(Long id);
}
