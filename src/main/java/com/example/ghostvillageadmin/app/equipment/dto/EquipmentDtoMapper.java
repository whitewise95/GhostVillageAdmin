package com.example.ghostvillageadmin.app.equipment.dto;

import com.example.ghostvillageadmin.app.equipment.entity.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentDtoMapper {

	EquipmentDtoMapper INSTANCE = Mappers.getMapper(EquipmentDtoMapper.class);

	Equipment create(EquipmentDto.Create create);
}
