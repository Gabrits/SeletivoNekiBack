package com.SeletivoNeki.dto;

import com.SeletivoNeki.Enum.UsuarioRole;

public record RegisterDto(String login, String password, UsuarioRole role) {
}
