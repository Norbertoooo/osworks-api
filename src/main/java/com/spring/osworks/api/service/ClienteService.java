package com.spring.osworks.api.service;

import com.spring.osworks.api.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Long id);
    Cliente saveOne(Cliente cliente);
    void deleteById(Long id);
    boolean existById(Long id);
}
