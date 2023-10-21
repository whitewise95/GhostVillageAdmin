package com.example.ghostvillageadmin.app.equipment.dto;

import com.example.ghostvillageadmin.app.equipment.entity.Equipment;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentElement;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentStat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentDtoMapper {

	EquipmentDtoMapper INSTANCE = Mappers.getMapper(EquipmentDtoMapper.class);

	@Mapping(target = "enforceLastType", source = "lastType")
	@Mapping(target = "enforceLastValue", source = "last")
	Equipment create(EquipmentDto.Create create);

	EquipmentElement createElement(EquipmentDto.CreateOrUpdateElement createElement);

	@Mapping(target = "statIncrease", source = "statAdd")
	EquipmentStat createStat(EquipmentDto.CreateOrUpdateStats createStats);

	@Mapping(target = "rank_type", source = "rankType")
	@Mapping(target = "last_type", source = "enforceLastType")
	@Mapping(target = "image_id", source = "imageId")
	EquipmentDto.Response toResponse(Equipment equipment);

	@Mapping(target = "rank_type", source = "rankType")
	@Mapping(target = "last_type", source = "enforceLastType")
	@Mapping(target = "image_id", source = "imageId")
	@Mapping(target = "last", source = "enforceLastValue")
	EquipmentDto.DetailResponse toDetailResponse(Equipment equipment);

	@Mapping(target = "statAdd", source = "statIncrease")
	EquipmentDto.StatsDetailResponse toStatsDetailResponse(EquipmentStat equipmentStat);

	EquipmentDto.ElementDetailResponse toElementDetailResponse(EquipmentElement equipmentElement);

	@Mapping(target = "enforceLastType", source = "lastType")
	@Mapping(target = "enforceLastValue", source = "last")
	void update(EquipmentDto.Update update, @MappingTarget Equipment equipment);

	void updateElement(EquipmentDto.CreateOrUpdateElement createOrUpdateElement, @MappingTarget EquipmentElement equipmentElement);


	void updateStats(EquipmentDto.CreateOrUpdateStats createOrUpdateStats, @MappingTarget EquipmentStat equipmentStat);
}
