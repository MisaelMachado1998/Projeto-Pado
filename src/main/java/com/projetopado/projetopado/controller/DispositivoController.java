package com.projetopado.projetopado.controller;

import com.projetopado.projetopado.dto.DispositivoDto;
import com.projetopado.projetopado.model.Dispositivo;
import com.projetopado.projetopado.service.DispositivoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@NoArgsConstructor
public class DispositivoController {

    @Autowired
    DispositivoService dispositivoService;

    @PostMapping
    @RequestMapping("/registrar")

    private ResponseEntity<DispositivoDto> salvarDispositivo(@RequestBody Dispositivo dispositivo) {
        return new ResponseEntity<DispositivoDto>(this.dispositivoService.salvar(dispositivo), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/listar")
    public List<Dispositivo> listarDispositivo() {
        return dispositivoService.listarDispositivos();
    }

    @GetMapping
    @RequestMapping("/listar/{id}")
    public Optional<Dispositivo> listarPorId(@PathVariable Long id) {
        return dispositivoService.listarPorId(id);
    }

    @PostMapping
    @RequestMapping("/registrar/async")
    private List<Long> salvarLista(@RequestBody List<Dispositivo> dispositivoList) {
        return dispositivoService.salvarLista(dispositivoList);
    }
}

