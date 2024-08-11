package com.SeletivoNeki.repository;

import com.SeletivoNeki.dto.UsuarioSkillResponseDto;
import com.SeletivoNeki.model.Skill;
import com.SeletivoNeki.model.UsuarioSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
//    @Query(value = "SELECT us.usuario_id,us.skill_id, us.id, us.level\n" +
//            "FROM usuarios u\n" +
//            "JOIN usuarios_skills us ON u.id = us.usuario_id\n" +
//            "JOIN skills s ON s.id = us.skill_id\n" +
//            "WHERE u.id = :id;",nativeQuery = true)
//    List<UsuarioSkill> findAllSkillsByUserId(Long id);
}
