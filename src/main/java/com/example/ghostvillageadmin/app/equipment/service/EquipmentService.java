package com.example.ghostvillageadmin.app.equipment.service;

import com.example.ghostvillageadmin.app.equipment.dto.EquipmentDto;
import com.example.ghostvillageadmin.app.equipment.dto.EquipmentDtoMapper;
import com.example.ghostvillageadmin.app.equipment.entity.Equipment;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
public class EquipmentService {

	private final EquipmentRepository equipmentRepository;

	@Transactional
	public void create(EquipmentDto.Create create) {

		Equipment equipment = EquipmentDtoMapper.INSTANCE.create(create);


	}
}
