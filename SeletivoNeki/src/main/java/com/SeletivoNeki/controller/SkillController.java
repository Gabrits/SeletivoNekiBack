package com.SeletivoNeki.controller;

import com.SeletivoNeki.dto.SkillDto;
import com.SeletivoNeki.repository.SkillRepository;
import com.SeletivoNeki.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillDto>> listar() {
        return ResponseEntity.ok(skillService.listarSkills());
    }

}
