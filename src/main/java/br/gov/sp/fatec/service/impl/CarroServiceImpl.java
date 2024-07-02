package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    public CarroResponse save(CarroRequest carroRequest) {
        Carro obj = new Carro();
        obj.setModelo(carroRequest.modelo());
        obj.setMarca(carroRequest.marca());
        obj.setAno(carroRequest.ano());

        Carro save = carroRepository.save(obj);

        return CarroResponse.builder().status(save.getStatus()).build();
    }

    @Override
    public CarroResponse findById(Long id) {
        return null;
    }

    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    public void updateById(Long id, CarroUpdateRequest carroUpdateRequest) {}

    @Override
    public void deleteById(Long id) {
        Carro carro = carroRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        carroRepository.delete(carro);
    }
}
