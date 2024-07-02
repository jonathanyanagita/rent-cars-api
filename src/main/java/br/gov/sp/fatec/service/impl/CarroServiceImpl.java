package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper mapper = CarroMapper.instance;

    @Override
    public CarroResponse save(CarroRequest carroRequest) {
        Carro obj = mapper.map(carroRequest);
        return mapper.map(carroRepository.save(obj));
    }

    @Override
    public CarroResponse findById(Long id) {
        Carro obj = carroRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Carro não encontrado com base no id: "+id));
        return mapper.map(obj);
    }

    @Override
    public List<CarroResponse> findAll() {
        return carroRepository.findAll().stream().map(mapper::map).toList();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        findById(id);
        carroRepository.deleteById(id);
    }
}
