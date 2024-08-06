package com.SeletivoNeki.repository;

import com.SeletivoNeki.model.UsuarioSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Long> {
}
