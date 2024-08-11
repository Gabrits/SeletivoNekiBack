package com.SeletivoNeki.controller;

import com.SeletivoNeki.dto.UsuarioSkillRequestDto;
import com.SeletivoNeki.dto.UsuarioSkillResponseDto;
import com.SeletivoNeki.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skills/{id}")
    public ResponseEntity<List<UsuarioSkillResponseDto>>findAllSkillsByUserId(@PathVariable Long id){
    return ResponseEntity.ok(skillService.findAllSkillsByUserId(id));
    }

    @PostMapping("/skills")
    public ResponseEntity<UsuarioSkillResponseDto>atribuirSkill(@RequestBody UsuarioSkillRequestDto dto){
        return ResponseEntity.ok(skillService.atribuirSkill(dto));
    }

    @DeleteMapping("/skills/{usuarioId}/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long usuarioId, @PathVariable Long skillId) {
        skillService.deleteSkill(usuarioId, skillId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/skills/{usuarioId}/{skillId}")
    public ResponseEntity<UsuarioSkillResponseDto> updateSkill(
            @PathVariable Long usuarioId,
            @PathVariable Long skillId,
            @RequestBody UsuarioSkillRequestDto dto) {
        return ResponseEntity.ok(skillService.updateSkill(usuarioId, skillId, dto));
    }

    @GetMapping("/skills")
    public ResponseEntity<List<UsuarioSkillResponseDto>> findAllSkills() {
        return ResponseEntity.ok(skillService.findAllSkills());
    }

}
