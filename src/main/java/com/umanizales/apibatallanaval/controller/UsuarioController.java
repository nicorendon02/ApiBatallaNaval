package com.umanizales.apibatallanaval.controller;

import com.umanizales.apibatallanaval.model.entities.Usuario;
import com.umanizales.apibatallanaval.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "usuario")
@Validated
public class UsuarioController {
    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> findAll()
    {
        return usuarioService.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody Usuario usuario)
    {
        return usuarioService.create(usuario);
    }

    @GetMapping(path = "userbyrol/{codeRol}")
    public @ResponseBody ResponseEntity<Object> findUsersByCodeRol(@PathVariable("codeRol") short codeRol)
    {
        return usuarioService.findUsersByRol(codeRol);
    }
    @GetMapping(path = "userbymail/{mail}")
    public @ResponseBody ResponseEntity<Object> findUsersByMail(@PathVariable("mail") String mail)
    {
        return usuarioService.findUsersByMail(mail);
    }
}