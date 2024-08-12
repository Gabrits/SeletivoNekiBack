package com.SeletivoNeki.controller;

import com.SeletivoNeki.dto.UsuarioSkillRequestDto;
import com.SeletivoNeki.dto.UsuarioSkillResponseDto;
import com.SeletivoNeki.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private SkillService skillService;

    @Operation(summary = "Lista todas as skills de um determinado usuário.")
    @GetMapping("/skills/{id}")
    public ResponseEntity<List<UsuarioSkillResponseDto>>findAllSkillsByUserId(@PathVariable Long id){
    return ResponseEntity.ok(skillService.findAllSkillsByUserId(id));
    }

    @Operation(summary = "Atribui skills ao usuario selecionado")
    @PostMapping("/skills")
    public ResponseEntity<UsuarioSkillResponseDto>atribuirSkill(@RequestBody UsuarioSkillRequestDto dto){
        return ResponseEntity.ok(skillService.atribuirSkill(dto));
    }

    @Operation(summary = "Deleta a skill do usuario selecionado")
    @DeleteMapping("/skills/{usuarioId}/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long usuarioId, @PathVariable Long skillId) {
        skillService.deleteSkill(usuarioId, skillId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Altera o level da skill de um usuario")
    @PutMapping("/skills/{usuarioId}/{skillId}")
    public ResponseEntity<UsuarioSkillResponseDto> updateSkill(
            @PathVariable Long usuarioId,
            @PathVariable Long skillId,
            @RequestBody UsuarioSkillRequestDto dto) {
        return ResponseEntity.ok(skillService.updateSkill(usuarioId, skillId, dto));
    }

    @Operation(summary = "Lista todas as skills")
    @GetMapping("/skills")
    public ResponseEntity<List<UsuarioSkillResponseDto>> findAllSkills() {
        return ResponseEntity.ok(skillService.findAllSkills());
    }

}
