package com.spring.osworks.api.service;

import com.spring.osworks.api.model.OrdemServico;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoService {

    OrdemServico save(OrdemServico ordemServico);
    List<OrdemServico> findAll();
    Optional<OrdemServico> findById(Long id);
    void deleteById(Long id);
}
