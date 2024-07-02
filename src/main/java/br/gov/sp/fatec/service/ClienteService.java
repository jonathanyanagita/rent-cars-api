package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import java.util.List;

public interface ClienteService {
    ClienteResponse save(ClienteRequest clienteRequest);

    Cliente findById(Long id);

    List<Cliente> findAll();

    void updateById(Long id, ClienteUpdateRequest clienteUpdateRequest);

    void deleteById(Long id);
}
