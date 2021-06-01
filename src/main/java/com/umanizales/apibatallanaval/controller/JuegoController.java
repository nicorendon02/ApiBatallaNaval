package com.umanizales.apibatallanaval.controller;

import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.RequestJuegoDTO;
import com.umanizales.apibatallanaval.service.JuegoService;
import com.umanizales.apibatallanaval.service.ListaDEService;
import com.umanizales.apibatallanaval.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public JuegoController(UsuarioService usuarioService,
                           ListaDEService listaDEService, JuegoService juegoService) {
        this.usuarioService = usuarioService;
        this.listaDEService = listaDEService;
        this.juegoService = juegoService;
    }

    @PostMapping(path = "/crear")
    public @ResponseBody ResponseEntity<Object> crearJuego(@RequestBody RequestJuegoDTO juegoDTO)
    {
        return juegoService.crearJuego(juegoDTO.getUsuario1(),juegoDTO.getUsuario2());
    }

    @PostMapping(path = "/validar")
    public @ResponseBody ResponseEntity<Object> validarCoordenadas(
            @RequestBody CoordenadaDTO[] coordenadas)
    {
        return listaDEService.validarExistenciaCoordenadas(coordenadas);
    }

    @GetMapping(path = "/visualizar")
    public @ResponseBody ResponseEntity<Object> visualizarLista()
    {
        return listaDEService.visualizarListaDE();
    }

}