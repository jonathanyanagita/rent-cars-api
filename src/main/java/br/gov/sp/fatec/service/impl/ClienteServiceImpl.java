package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper = ClienteMapper.instance;

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        Cliente obj = mapper.map(clienteRequest);
        return mapper.map(clienteRepository.save(obj));
    }

    @Override
    public ClienteResponse findById(Long id) {
        Cliente obj = clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente não encontrado com base no id: "+id));
        return mapper.map(obj);
    }

    @Override
    public List<ClienteResponse> findAll() {
        return clienteRepository.findAll().stream().map(mapper::map).toList();    }


    @Transactional
    @Override
    public void deleteById(Long id) {
        findById(id);
        clienteRepository.deleteById(id);
    }
}
