package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        return null;
    }

    @Override
    public ClienteResponse findById(Long id) {
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void updateById(Long id, ClienteUpdateRequest clienteUpdateRequest) {}

    @Override
    public void deleteById(Long id) {
        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}
