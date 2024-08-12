package com.SeletivoNeki.Enum;

public enum LevelSkill {
    INICIANTE("INICIANTE"),
    INTERMEDIARIO("INTERMEDIARIO"),
    AVANCADO("AVANCADO");

    private final String level;

    LevelSkill (String level) {
        this.level = level;
    }
    public String getLevelName(){
        return level;
    }
}
