package com.spring.osworks.api.controller;

import com.spring.osworks.api.model.OrdemServico;
import com.spring.osworks.api.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> cadastrar(@Valid @RequestBody OrdemServico ordemServico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServicoService.save(ordemServico));
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> buscarTodos() {
        return ResponseEntity.ok(ordemServicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable Long id) {
        Optional<OrdemServico> ordemServico = ordemServicoService.findById(id);
        if( ordemServico.isPresent() ) {
            return ResponseEntity.ok(ordemServico.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        ordemServicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
