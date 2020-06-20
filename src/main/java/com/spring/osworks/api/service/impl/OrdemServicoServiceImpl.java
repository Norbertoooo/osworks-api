package com.spring.osworks.api.service.impl;

import com.spring.osworks.api.exceptionHandler.DomainException;
import com.spring.osworks.api.model.Cliente;
import com.spring.osworks.api.model.OrdemServico;
import com.spring.osworks.api.model.StatusOrdemServico;
import com.spring.osworks.api.repository.OrdemServicoRepository;
import com.spring.osworks.api.service.ClienteService;
import com.spring.osworks.api.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteService clienteService;

    @Override
    public OrdemServico save(OrdemServico ordemServico) {
        Cliente cliente = clienteService.getClienteById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new DomainException("Cliente não encontrado"));
        ordemServico.setCliente(cliente);
        ordemServico.setDataAbertura(OffsetDateTime.now());
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public Optional<OrdemServico> findById(Long id) {
        return ordemServicoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        ordemServicoRepository.deleteById(id);
    }
}
