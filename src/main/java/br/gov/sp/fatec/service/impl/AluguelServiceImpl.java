package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper mapper = AluguelMapper.instance;


    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel obj = mapper.map(aluguelRequest);
        return mapper.map(aluguelRepository.save(obj));
    }

    @Transactional(readOnly = true)
    @Override
    public AluguelResponse findById(Long id) {
        Aluguel obj = aluguelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Aluguel não encontrado com base no id: "+id));
        return mapper.map(obj);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AluguelResponse> findAll() {
        return aluguelRepository.findAll().stream().map(mapper::map).toList();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        findById(id);
        aluguelRepository.deleteById(id);
    }
}
