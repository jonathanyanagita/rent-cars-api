package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import java.util.List;

public interface CarroService {
    CarroResponse save(CarroRequest carroRequest);

    Carro findById(Long id);

    List<CarroResponse> findAll();

    void updateById(Long id, CarroUpdateRequest carroUpdateRequest);

    void deleteById(Long id);
}
