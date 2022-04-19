package com.projetopado.projetopado.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DispositivoDto implements Serializable {
    private Long deviceId;
    private String mac;

    public DispositivoDto(Long deviceId, String mac){
        this.deviceId = deviceId;
        this.mac = mac;
    }
}
