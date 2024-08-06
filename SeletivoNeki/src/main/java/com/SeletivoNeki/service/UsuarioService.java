package com.SeletivoNeki.service;
import com.SeletivoNeki.dto.UsuarioDto;
import com.SeletivoNeki.model.Usuario;
import com.SeletivoNeki.repository.SkillRepository;
import com.SeletivoNeki.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findByLogin(usuarioDto.getLogin());
        if (usuario != null && passwordEncoder.matches(usuarioDto.getSenha(), usuario.getSenha())){
            return usuario;
        }
        return null;
    }
}
