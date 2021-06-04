package com.umanizales.apibatallanaval.controller;

import com.umanizales.apibatallanaval.model.dto.Coordenada;
import com.umanizales.apibatallanaval.model.dto.CoordenadaDTO;
import com.umanizales.apibatallanaval.model.dto.DistribucionBarcoDTO;
import com.umanizales.apibatallanaval.model.entities.Barco;
import com.umanizales.apibatallanaval.service.ListaDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "listabarcos")
public class ListaDEController {
    private ListaDEService listaDEService;
    @Autowired
    public ListaDEController(ListaDEService listaDEService) {
        this.listaDEService = listaDEService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> visualizarLista()
    {
        return listaDEService.visualizarListaDE();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> adicionarDistribucionBarco(@RequestBody Barco barco, CoordenadaDTO[] posicion)
    {

        DistribucionBarcoDTO distribucion = new DistribucionBarcoDTO(barco, posicion);
        return listaDEService.adicionarDistribucionBarco(distribucion);
    }


    @GetMapping("cont")
    public @ResponseBody ResponseEntity<Object> contarNodos()
    {
        return listaDEService.contarNodos();
    }
}