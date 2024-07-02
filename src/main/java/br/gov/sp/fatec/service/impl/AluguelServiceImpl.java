package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel obj = new Aluguel();
        obj.setDataInicio(aluguelRequest.dataInicio());
        obj.setDataFim(aluguelRequest.dataFim());
        obj.setValor(aluguelRequest.valor());

        Aluguel save = aluguelRepository.save(obj);

        return AluguelResponse.builder().status(save.getStatus()).build();
    }

    @Override
    public AluguelResponse findById(Long id) {
        return null;
    }

    @Override
    public List<Aluguel> findAll() {
        return aluguelRepository.findAll();
    }

    @Override
    public void updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {}

    @Override
    public void deleteById(Long id) {
        Aluguel aluguel = aluguelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
        aluguelRepository.delete(aluguel);
    }
}
