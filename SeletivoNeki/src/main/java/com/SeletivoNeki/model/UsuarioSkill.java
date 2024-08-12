package com.SeletivoNeki.model;

import com.SeletivoNeki.Enum.LevelSkill;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios_Skills")
public class UsuarioSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private LevelSkill level;

    public UsuarioSkill() {
    }

    public UsuarioSkill(Usuario usuario, Skill skill, LevelSkill level, Long id) {
        this.usuario = usuario;
        this.skill = skill;
        this.level = level;
        this.id = id;
    }

    public UsuarioSkill(Usuario usuario, Skill skill, LevelSkill level) {
        this.usuario = usuario;
        this.skill = skill;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getusuario() {
        return usuario;
    }

    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public LevelSkill getLevel() {
        return level;
    }

    public void setLevel(LevelSkill level) {
        this.level = level;
    }
}
