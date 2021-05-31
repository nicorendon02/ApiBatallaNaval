package com.umanizales.apibatallanaval.model;

import com.umanizales.apibatallanaval.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Juego {
    public int id;
    public Tablero tableroJugador1;
    public Tablero TableroJugador2;
    public int numeroBarcos; // preguntar cual es este tipo de dato ???
    public byte turno;
    public int aciertosJug1;
    public int aciertosJug2;

    public Juego(int id, Tablero tableroJugador1, Tablero tableroJugador2,
                 int numeroBarcos, byte turno, int aciertosJug1, int aciertosJug2) {
        this.id = id;
        this.tableroJugador1 = tableroJugador1;
        TableroJugador2 = tableroJugador2;
        this.numeroBarcos = numeroBarcos;
        this.turno = turno;
        this.aciertosJug1 = aciertosJug1;
        this.aciertosJug2 = aciertosJug2;
    }

    public String validarDisparo(int x, int y) // preguntar parametros de este metodo???
    {
        return null;
    }

    public void crearTableros() // terminar!!!
    {
    }

    public Usuario validarGanador() //terminar!!!
    {
        return null;
    }
}