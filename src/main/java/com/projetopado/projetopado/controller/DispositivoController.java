package com.projetopado.projetopado.controller;

import com.projetopado.projetopado.model.Dispositivo;
import com.projetopado.projetopado.service.DispositivoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    private Dispositivo salvarDispositivo(@RequestBody Dispositivo dispositivo) {
        return dispositivoService.salvar(dispositivo);
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
}

