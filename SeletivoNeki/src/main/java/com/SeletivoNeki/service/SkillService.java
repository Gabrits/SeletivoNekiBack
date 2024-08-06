package com.SeletivoNeki.service;

import com.SeletivoNeki.dto.SkillDto;
import com.SeletivoNeki.model.Skill;
import com.SeletivoNeki.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<SkillDto> listarSkills () {
        List<Skill> skills = skillRepository.findAll();

        List<SkillDto> skillDto = new ArrayList<>();

        for (Skill skill: skills) {
            SkillDto skDto = new SkillDto(skill);
            skillDto.add(skDto);
        }
        return skillDto;
    }

    public SkillDto inseri(SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setNome(skillDto.getNome());
        skill.setDescricao(skillDto.getDescricao());
        skill.setImagemUrl(skillDto.getImagemUrl());
        skill = skillRepository.save(skill);
        return new SkillDto(skill);
    }

    public SkillDto atualizar(Long id, SkillDto skillDto) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));
        skill.setNome(skillDto.getNome());
        skill.setDescricao(skillDto.getDescricao());
        skill.setImagemUrl(skillDto.getImagemUrl());
        skill = skillRepository.save(skill);
        return new SkillDto(skill);
    }

    public void deletar(Long id){
        if (skillRepository.existsById(id)){
            skillRepository.deleteById(id);
        } else {
            throw new RuntimeException("Habilidade não encontrada");
        }
    }

}