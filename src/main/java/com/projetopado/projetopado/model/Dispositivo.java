package com.projetopado.projetopado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dispositivo")
@Accessors(chain = true)
public class Dispositivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceId")
    private Long id;
    private String name;
    private String mac;
    private String email;
    private Integer latitude;
    private Integer longitude;

    public Dispositivo(Long id, String mac) {
        this.id = id;
        this.name = name;
        this.mac = mac;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
