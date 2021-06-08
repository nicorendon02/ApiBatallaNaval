package com.umanizales.apibatallanaval.controller;

import com.umanizales.apibatallanaval.model.Tablero;
import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.RequestJuegoDTO;
import com.umanizales.apibatallanaval.model.dto.RespuestaDTO;
import com.umanizales.apibatallanaval.model.entities.Barco;
import com.umanizales.apibatallanaval.service.JuegoService;
import com.umanizales.apibatallanaval.service.ListaDEService;
import com.umanizales.apibatallanaval.service.UsuarioService;
import com.umanizales.apibatallanaval.repository.UsuarioRepository;
import com.umanizales.apibatallanaval.model.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/juego")
@Validated
public class JuegoController {

    // Inyecto los servicios
    private UsuarioService usuarioService;
    private ListaDEService listaDEService;
    private JuegoService juegoService;
    private UsuarioRepository usuarioRepository;

    public JuegoController(UsuarioService usuarioService, ListaDEService listaDEService,
                           JuegoService juegoService, UsuarioRepository usuarioRepository)
    {
        this.usuarioService = usuarioService;
        this.listaDEService = listaDEService;
        this.juegoService = juegoService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping(path = "/crear")
    public @ResponseBody ResponseEntity<Object> crearJuego(@RequestBody RequestJuegoDTO juegoDTO) {

        // consulta para saber si usuarios existen
        String usuario1 = juegoDTO.getUsuario1();
        String usuario2 = juegoDTO.getUsuario2();
        try {
            Usuario jugador1 = usuarioRepository.obtenerUsuarioPorCorreo(usuario1);
            Usuario jugador2 = usuarioRepository.obtenerUsuarioPorCorreo(usuario2);

            if (jugador1 != null && jugador2 != null) {
                return juegoService.crearJuego(jugador1, jugador2);
            } else {
                return new ResponseEntity<>(new RespuestaDTO("Error",
                        null, "Usuarios no concuerdan con base de datos"),
                        HttpStatus.CONFLICT  );
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null, "El usuario no esta en la base de datos"),
                    HttpStatus.CONFLICT);
        }
    }

    @PostMapping(path = "/validar")
    public @ResponseBody ResponseEntity<Object> validarCoordenadas(
            @RequestBody CoordenadaDTO[] coordenadas)
    {
        return listaDEService.validarExistenciaCoordenadas(coordenadas);
    }

    /*
    @GetMapping(path = "/visualizar")
    public @ResponseBody ResponseEntity<Object> visualizarLista()
    {
        return listaDEService.visualizarListaDE();
    }

    */
    // nuevo
    @PostMapping(path = "/organizarbarcos")
    public @ResponseBody ResponseEntity<Object> organizarBarco(@RequestBody String correo,
                                                               int x, int y, byte orientacion,
                                                               int posBarcoLista)
    {
        Usuario jugador = usuarioRepository.obtenerUsuarioPorCorreo(correo);

        try {
            if (jugador.getCorreo() == correo)

                return juegoService.organizarBarco(x, y, orientacion, jugador, posBarcoLista);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",null,
                    "El usuario no esta en la base de datos"),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",null,
                "El barco se ha posicionado"),HttpStatus.OK);
    }

    @GetMapping(path = "/visualizartablero1")
    public @ResponseBody Tablero visualizarTablero1()
    {
        return juegoService.visualizarTablero1();
    }

    @GetMapping(path = "/visualizartablero2")
    public @ResponseBody Tablero visualizarTablero2()
    {
        return juegoService.visualizarTablero2();
    }

    /*
    @GetMapping(path = "/ganador")
    public @ResponseBody ResponseEntity<Object> validarGanador(@RequestBody RequestJuegoDTO juegoDTO)
    {

        String usuario1 = juegoDTO.getUsuario1();
        String usuario2 = juegoDTO.getUsuario2();
        Usuario jugador1 = usuarioRepository.obtenerUsuarioPorCorreo(usuario1);
        Usuario jugador2 = usuarioRepository.obtenerUsuarioPorCorreo(usuario2);
        return juegoService.validarGanador(jugador1,jugador2);

        return null;
    }
    */
}