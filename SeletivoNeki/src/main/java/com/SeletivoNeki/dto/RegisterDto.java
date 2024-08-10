package com.SeletivoNeki.dto;

import com.SeletivoNeki.model.UsuarioRole;

public record RegisterDto(String login, String password, UsuarioRole role) {
}
