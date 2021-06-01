package com.umanizales.apibatallanaval.model;

import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.DistribucionBarcoDTO;
import com.umanizales.apibatallanaval.model.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Juego {
    public int id;
    public Tablero tableroJugador1;
    public Tablero tableroJugador2;
    public int numeroBarcos; // preguntar cual es este tipo de dato ???
    public byte turno;
    public int aciertosJug1;
    public int aciertosJug2;

    public ListaDE listaDE;
    public DistribucionBarcoDTO distribucionBarcoDTO;
    public CoordenadaDTO coordenadaDTO;

    public Juego(int id, Usuario jugador1, Usuario jugador2, int numeroBarcos)
    {
        this.id = id;
        this.numeroBarcos = numeroBarcos;
        tableroJugador1 = new Tablero(id,10,10,jugador1, listaDE.clonarLista());
        tableroJugador2 = new Tablero(id,10,10,jugador2, listaDE.clonarLista());
    }

    public void crearTableros() // terminar!!!
    {
        if (numeroBarcos > 0 && numeroBarcos <= 9)
        {
            // preguntar
        }
        if (numeroBarcos > 9 && numeroBarcos <= 20)
        {
            // preguntar
        }
        if (numeroBarcos > 20)
        {
            // preguntar
        }
    }

    public boolean disparar(int x, int y)
    {
       // CoordenadaDTO coordenada = new CoordenadaDTO(x,y,true);
        return false;
    }

        public String validarDisparo(int x, int y) // preguntar parametros de este metodo???
        {
                return null;
        }

    public Usuario validarGanador() //terminar!!!
    {
        return null;
    }
}