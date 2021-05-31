package com.umanizales.apibatallanaval.model.dto;

import com.umanizales.apibatallanaval.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestJuegoDTO implements Serializable {
    private Usuario usuario1;
    private Usuario usuario2;
    //private int numBarcos;
}
