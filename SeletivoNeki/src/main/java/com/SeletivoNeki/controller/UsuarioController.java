package com.SeletivoNeki.controller;

import com.SeletivoNeki.dto.UsuarioDto;
import com.SeletivoNeki.model.Usuario;
import com.SeletivoNeki.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.cadastrar(usuarioDto);
    return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.autenticar(usuarioDto);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.status(401).build();
    }
}
