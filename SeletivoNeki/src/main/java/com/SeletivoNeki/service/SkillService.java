package com.SeletivoNeki.service;

import com.SeletivoNeki.exception.NotFoundException;
import com.SeletivoNeki.dto.SkillDto;
import com.SeletivoNeki.dto.UsuarioSkillRequestDto;
import com.SeletivoNeki.dto.UsuarioSkillResponseDto;
import com.SeletivoNeki.model.Skill;
import com.SeletivoNeki.model.Usuario;
import com.SeletivoNeki.model.UsuarioSkill;
import com.SeletivoNeki.repository.SkillRepository;
import com.SeletivoNeki.repository.UsuarioRepository;
import com.SeletivoNeki.repository.UsuarioSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioSkillRepository usuarioSkillRepository;

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

    public List<UsuarioSkillResponseDto> findAllSkillsByUserId(Long id){
        if (usuarioRepository.findById(id).isEmpty()){
            throw new NotFoundException("Skill não encontrada.");
        }
        List<UsuarioSkillResponseDto> skills = usuarioSkillRepository.findAllSkillsByUserId(id).stream().map(UsuarioSkillResponseDto::new).toList();
        return skills;
    }

    public UsuarioSkillResponseDto atribuirSkill(UsuarioSkillRequestDto usuarioSkillDto){
        Usuario usuario = usuarioRepository.findById(usuarioSkillDto.getUsuarioId()).orElseThrow(NotFoundException::new);
        Skill skill = skillRepository.findById(usuarioSkillDto.getSkillId()).orElseThrow(NotFoundException::new);
        return new UsuarioSkillResponseDto(usuarioSkillRepository.save(new UsuarioSkill(usuario, skill, usuarioSkillDto.getLevel())));
    }

    public void deleteSkill(Long usuarioId, Long skillId) {
        UsuarioSkill usuarioSkill = usuarioSkillRepository.findByUsuarioIdAndSkillId(usuarioId, skillId)
                .orElseThrow(() -> new NotFoundException("Skill não encontrada para o usuário."));
        usuarioSkillRepository.delete(usuarioSkill);
    }

    public UsuarioSkillResponseDto updateSkill(Long usuarioId, Long skillId, UsuarioSkillRequestDto usuarioSkillDto) {
        UsuarioSkill usuarioSkill = usuarioSkillRepository.findByUsuarioIdAndSkillId(usuarioId, skillId)
                .orElseThrow(() -> new NotFoundException("Skill não encontrada para o usuário."));
        usuarioSkill.setLevel(usuarioSkillDto.getLevel());
        return new UsuarioSkillResponseDto(usuarioSkillRepository.save(usuarioSkill));
    }

    public List<UsuarioSkillResponseDto> findAllSkills() {
        List<UsuarioSkill> skills = usuarioSkillRepository.findAll();
        return skills.stream().map(UsuarioSkillResponseDto::new).toList();
    }


}