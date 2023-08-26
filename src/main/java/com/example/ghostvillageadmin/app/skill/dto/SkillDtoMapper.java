package com.example.ghostvillageadmin.app.skill.dto;

import com.example.ghostvillageadmin.app.skill.domain.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillDtoMapper {

	SkillDtoMapper INSTANCE = Mappers.getMapper(SkillDtoMapper.class);

	SkillDto.Response toResponse(Skill skill);

	Skill create(SkillDto.Create create);

	SkillDto.DetailResponse toDetailResponse(Skill skill);

	void update(SkillDto.Update update, @MappingTarget Skill skill);
}
