package com.umanizales.apibatallanaval.model;

import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tablero {
    public int id;
    public int cols;
    public int filas;
    public Usuario jugador;
    public ListaDE listaBarco;
    public boolean estadoTablero;
    public List<CoordenadaDTO> disparosRecibidos;



    public Tablero(int id, int cols, int filas, Usuario jugador,
                   ListaDE listaBarco) {
        this.id = id;
        this.cols = cols;
        this.filas = filas;
        this.jugador = jugador;
        this.listaBarco = listaBarco;

    }

    public boolean validarExistenciaCoordenada(Tablero tablero, int filas, int cols)
    {
        if (filas <= tablero.getFilas() && cols <= tablero.getCols())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String validarDisparo(int x, int y)
    {
        return null;
    }

    public void ocupacionCoordenada (int filas, int cols)
    {
    }
}