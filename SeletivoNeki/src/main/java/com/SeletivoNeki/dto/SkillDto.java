package com.SeletivoNeki.dto;

import com.SeletivoNeki.model.Skill;

public class SkillDto {

    private Long id;
    private String nome;
    private String descricao;
    private String imagemUrl;

    public SkillDto() {
    }

    public SkillDto(Skill skill) {
        this.id = skill.getId();
        this.nome = skill.getNome();
        this.descricao = skill.getDescricao();
        this.imagemUrl = skill.getImagemUrl();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
