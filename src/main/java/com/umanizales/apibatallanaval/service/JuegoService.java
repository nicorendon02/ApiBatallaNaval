package com.umanizales.apibatallanaval.service;

import com.umanizales.apibatallanaval.model.Juego;
import com.umanizales.apibatallanaval.model.Tablero;
import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.DistribucionBarcoDTO;
import com.umanizales.apibatallanaval.model.dto.RespuestaDTO;
import com.umanizales.apibatallanaval.model.entities.Usuario;
import com.umanizales.apibatallanaval.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoService {
    private ListaDEService listaDEService; //inyecto el servicio de ListaDE
    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;
    private DistribucionBarcoDTO distribucionBarcoDTO;


    // TERMINAR ESTE CONSTRUCTOR!!!
    @Autowired
    public JuegoService(ListaDEService listaDEService) {
        this.listaDEService = listaDEService;
    }

    //private List<Juego> juego;
    private Juego juego;

    public ResponseEntity<Object> crearJuego(Usuario jugador1, Usuario jugador2)
    {
        // validar y crear juego con los 2 tableros

        if (listaDEService.obtenerContadorLista()>0)
        {
            juego = new Juego(1,jugador1,jugador2,listaDEService.getListaBarcos());
            return new ResponseEntity<>(new RespuestaDTO("Juego creado",
                    juego,null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"Aun no ha distribuido la lista DE"),
                    HttpStatus.CONFLICT);
        }
    }

    public Tablero visualizarTablero1()
    {
        return (Tablero) juego.visualizarTablero1();
    }

    public Tablero visualizarTablero2()
    {
        return (Tablero) juego.visualizarTablero2();
    }

    public ResponseEntity<Object> validarExistenciaJuego(Tablero tablerojugador1, Tablero tablerojugador2)
    {
        tablerojugador1 = juego.tableroJugador1;
        tablerojugador2 = juego.tableroJugador2;
        if(tablerojugador1 != null && tablerojugador2 != null)
        {
            return new ResponseEntity<>(new RespuestaDTO("El juego ya esta creado",
                    null,null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"El juego no se ha creado aun"), HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> organizarBarco(int x, int y, byte orientacion, Usuario jugador,
                                                 int posBarcoLista)
    {
        try{
            CoordenadaDTO coordenadas = new CoordenadaDTO(x,y,false);
            boolean distribucion = distribucionBarcoDTO.validarExistenciaCoordenada(coordenadas);

            if (distribucion) {  // si es true...
                CoordenadaDTO[] coordSugeridas = distribucionBarcoDTO.sugerirUbicacion(x,y,orientacion);
                boolean validacion = listaDEService.validarCoordenadasNodo(coordSugeridas);

                if (!validacion)  // si es false...
                {
                    // llamar a organizar el barco con las coordenadas sugeridas
                }
            }
            else{
                return new ResponseEntity<>(new RespuestaDTO("Error",
                        null, "La coordenada no existe"),
                        HttpStatus.CONFLICT);
            }
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"El barco no pudo ser distribuido"), HttpStatus.CONFLICT);
        }
        return null;
    }

    /*
    public ResponseEntity<Object> validarGanador(Usuario jugador1, Usuario jugador2)
    {
        try{
            return new ResponseEntity<>(new RespuestaDTO("Ganador",
                    juego.validarGanador(jugador1,jugador2),null), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"Aun no hay un ganador"), HttpStatus.CONFLICT);
        }
    }

     */
}