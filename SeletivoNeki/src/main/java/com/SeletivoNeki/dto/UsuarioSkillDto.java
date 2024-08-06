package com.SeletivoNeki.dto;

import com.SeletivoNeki.model.Skill;
import com.SeletivoNeki.model.Usuario;
import com.SeletivoNeki.model.UsuarioSkill;

public class UsuarioSkillDto {

    private Long id;
    private Usuario usuario;
    private Skill skill;
    private String level;

    public UsuarioSkillDto() {
    }

    public UsuarioSkillDto(UsuarioSkill usuarioSkill) {
        this.id = usuarioSkill.getId();
        this.usuario = usuarioSkill.getusuario();
        this.skill = usuarioSkill.getSkill();
        this.level = usuarioSkill.getLevel();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
