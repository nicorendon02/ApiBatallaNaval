package com.umanizales.apibatallanaval.controller;

import com.umanizales.apibatallanaval.model.dto.Coordenada;
import com.umanizales.apibatallanaval.model.dto.RequestBarcoCoordenadaDTO;
import com.umanizales.apibatallanaval.service.TableroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/escondetubarco")
@Validated
public class TableroController {
    private TableroService tableroService;
    @Autowired
    public TableroController(TableroService tableroService)
    {
        this.tableroService = tableroService;
    }

    @PostMapping(path = "iniciar_tablero")
    public @ResponseBody
    ResponseEntity<Object> iniciarTablero(@RequestBody Coordenada coordenada)
    {
        return tableroService.inicializarTablero(coordenada.getFila(), coordenada.getCol());
    }

    @GetMapping(path="ver_tablero")
    public @ResponseBody ResponseEntity<Object> visualizarTablero()

    {
        return tableroService.visualizarTablero();
    }

    @PostMapping(path="esconderbarco")
    public @ResponseBody ResponseEntity<Object> esconderBarco
            (@RequestBody RequestBarcoCoordenadaDTO request)
    {
        return tableroService.esconderBarco(request.getCodigo(),request.getCoordenada());
    }


    @PostMapping(path="buscarbarco")
    public @ResponseBody ResponseEntity<Object> buscarBarco(@RequestBody Coordenada coordenada  )
    {
        return tableroService.buscarBarco(coordenada);
    }

}