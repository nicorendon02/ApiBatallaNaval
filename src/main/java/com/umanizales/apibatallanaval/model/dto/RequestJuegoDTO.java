package com.umanizales.apibatallanaval.model.dto;

import com.umanizales.apibatallanaval.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestJuegoDTO implements Serializable {
    private String usuario1;
    private String usuario2;
    //private int numBarcos;
}