package com.SeletivoNeki.model;

public enum LevelSkill {
    INICIANTE("INICIANTE"),
    INTERMEDIARIO("INTERMEDIÁRIO"),
    AVANCADO("AVANÇADO");

    private final String level;

    LevelSkill (String level) {
        this.level = level;
    }
    public String getLevelName(){
        return level;
    }
}
