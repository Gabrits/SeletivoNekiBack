package com.SeletivoNeki.dto;

import com.SeletivoNeki.model.LevelSkill;

public class UsuarioSkillRequestDto {

    private Long usuarioId;
    private Long skillId;
    private LevelSkill level;

    public UsuarioSkillRequestDto(Long usuarioId, Long skillId, LevelSkill level) {
        this.usuarioId = usuarioId;
        this.skillId = skillId;
        this.level = level;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public LevelSkill getLevel() {
        return level;
    }
}
