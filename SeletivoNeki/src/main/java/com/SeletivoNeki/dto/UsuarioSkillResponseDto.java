package com.SeletivoNeki.dto;

import com.SeletivoNeki.model.Skill;
import com.SeletivoNeki.model.UsuarioSkill;

public class UsuarioSkillResponseDto {

    private Long id;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private String level;

    public UsuarioSkillResponseDto(UsuarioSkill usuarioSkill) {
        this.id = usuarioSkill.getSkill().getId();
        this.nome = usuarioSkill.getSkill().getNome();
        this.descricao = usuarioSkill.getSkill().getDescricao();
        this.imagemUrl = usuarioSkill.getSkill().getImagemUrl();
        this.level = usuarioSkill.getLevel().getLevelName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
