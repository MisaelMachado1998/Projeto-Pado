package com.projetopado.projetopado.service;

import com.projetopado.projetopado.model.Dispositivo;
import com.projetopado.projetopado.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    DispositivoRepository dispositivoRepository;


    public Dispositivo salvar(@RequestBody Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public List<Dispositivo> listarDispositivos() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> listarPorId(Long id) {
        return dispositivoRepository.findById(id);
    }


}

