package com.projetopado.projetopado.dto;

import lombok.Data;

@Data
public class DispositivoDto {
    private Long deviceId;
    private String mac;

    public DispositivoDto(Long deviceId, String mac){
        this.deviceId = deviceId;
        this.mac = mac;
    }
}
