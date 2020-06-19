package com.spring.osworks.api.service.impl;

import com.spring.osworks.api.exceptionHandler.DomainException;
import com.spring.osworks.api.model.Cliente;
import com.spring.osworks.api.repository.ClienteRepository;
import com.spring.osworks.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente saveOne(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if( clienteExistente != null && !clienteExistente.getEmail().equals(cliente)) {
            throw new DomainException("Email já existente");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return clienteRepository.existsById(id);
    }
}
