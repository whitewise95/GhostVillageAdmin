package com.example.ghostvillageadmin.app.equipment.service;

import com.example.ghostvillageadmin.app.equipment.dto.EquipmentDto;
import com.example.ghostvillageadmin.app.equipment.dto.EquipmentDtoMapper;
import com.example.ghostvillageadmin.app.equipment.entity.Equipment;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentElement;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentElementRepository;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentRepository;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentStat;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentStatRepository;
import com.example.ghostvillageadmin.app.utils.PagableDto;
import com.example.ghostvillageadmin.exceptions.NotFoundException;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
public class EquipmentService {

	private final EquipmentRepository equipmentRepository;
	private final EquipmentElementRepository equipmentElementRepository;
	private final EquipmentStatRepository equipmentStatRepository;


	/**
	 * 장비 목록 조회
	 */
	public PagableDto.Response<EquipmentDto.Response> getEquipmentList(PagableDto.Request request) {
		Sort sort = Sort.by(request.getOrderType().dir, request.getSortField());

		Pageable pageRequest = PageRequest.of(request.getPage(), request.getLimit(), sort);
		Page<Equipment> equipmentList = equipmentRepository.findAll(pageRequest);

		return PagableDto.Response.of(equipmentList,
									  equipmentList.getContent()
												   .stream()
												   .map(EquipmentDtoMapper.INSTANCE::toResponse)
												   .toList());
	}

	/**
	 * 장비 상세 조회
	 */
	public EquipmentDto.DetailResponse getEquipment(Long id) {
		Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new NotFoundException("장비", true));
		EquipmentDto.DetailResponse detailResponse = EquipmentDtoMapper.INSTANCE.toDetailResponse(equipment);

		for (EquipmentStat equipmentStat : equipment.getEquipmentStatList()) {
			detailResponse.getStatsList().add(EquipmentDtoMapper.INSTANCE.toStatsDetailResponse(equipmentStat));
		}

		for (EquipmentElement equipmentElement : equipment.getEquipmentElementList()) {
			detailResponse.getElementList().add(EquipmentDtoMapper.INSTANCE.toElementDetailResponse(equipmentElement));
		}

		return detailResponse;
	}

	/**
	 * 장비 생성
	 */
	@Transactional
	public void create(EquipmentDto.Create create) {
		Equipment equipment = equipmentRepository.save(EquipmentDtoMapper.INSTANCE.create(create));
		createStatsBulk(create.getStatsList(), equipment);
		createElementBulk(create.getElementList(), equipment);
	}

	/**
	 * 장비 수정
	 */
	@Transactional
	public void update(Long id, EquipmentDto.Update update) {
		Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new NotFoundException("장비", true));
		EquipmentDtoMapper.INSTANCE.update(update, equipment);
		updateElementHandler(update, equipment);
		statUpdateHandler(update, equipment);

	}


	/**
	 * 장비 삭제
	 */
	@Transactional
	public void delete(Long id) {
		Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new NotFoundException("장비", true));
		equipmentRepository.delete(equipment);
	}

	/**
	 * 스탯 업데이트 핸들러
	 */
	private void statUpdateHandler(EquipmentDto.Update update, Equipment equipment) {
		Map<Boolean, List<EquipmentDto.@Valid CreateOrUpdateStats>> createOrUpdateMapIsCreate = update.getStatsList()
																									  .stream()
																									  .collect(Collectors.groupingBy(x -> x.getId() == null, Collectors.toList()));

		// remove
		List<EquipmentStat> removeList = equipment.getEquipmentStatList()
												  .stream()
												  .filter(entity -> update.getStatsList()
																		  .stream()
																		  .noneMatch(dto -> entity.getId().equals(dto.getId())))
												  .toList();

		if (!removeList.isEmpty()) {
			equipmentStatRepository.deleteAllInBatch(removeList);
		}

		// create
		if (createOrUpdateMapIsCreate.get(true) != null) {
			createStatsBulk(createOrUpdateMapIsCreate.get(true), equipment);
		}

		// update
		if (createOrUpdateMapIsCreate.get(false) != null) {
			Map<Long, EquipmentDto.CreateOrUpdateStats> updateMap = new HashMap<>();
			for (EquipmentDto.CreateOrUpdateStats updateStats : createOrUpdateMapIsCreate.get(false)) {
				updateMap.put(updateStats.getId(), updateStats);
			}

			for (EquipmentStat equipmentStat : equipment.getEquipmentStatList()) {
				if (updateMap.containsKey(equipmentStat.getId())) {
					EquipmentDtoMapper.INSTANCE.updateStats(updateMap.get(equipmentStat.getId()), equipmentStat);
				}
			}
		}
	}

	/**
	 * 속성 업데이트 핸들러
	 */
	private void updateElementHandler(EquipmentDto.Update update, Equipment equipment) {
		Map<Boolean, List<EquipmentDto.CreateOrUpdateElement>> createOrUpdateMapIsCreate = update.getElementList()
																										.stream()
																										.collect(Collectors.groupingBy(x -> x.getId() == null, Collectors.toList()));

		// remove
		List<EquipmentElement> removeList = equipment.getEquipmentElementList()
													 .stream()
													 .filter(entity -> update.getElementList()
																			 .stream()
																			 .noneMatch(dto -> entity.getId().equals(dto.getId())))
													 .toList();
		if (!removeList.isEmpty()) {
			equipmentElementRepository.deleteAllInBatch(removeList);
		}

		// create
		if (createOrUpdateMapIsCreate.get(true) != null) {
			createElementBulk(createOrUpdateMapIsCreate.get(true), equipment);
		}

		// update
		if (createOrUpdateMapIsCreate.get(false) != null) {
			Map<Long, EquipmentDto.CreateOrUpdateElement> updateMap = new HashMap<>();
			for (EquipmentDto.CreateOrUpdateElement updateElement : createOrUpdateMapIsCreate.get(false)) {
				updateMap.put(updateElement.getId(), updateElement);
			}

			for (EquipmentElement equipmentElement : equipment.getEquipmentElementList()) {
				if (updateMap.containsKey(equipmentElement.getId())) {
					EquipmentDtoMapper.INSTANCE.updateElement(updateMap.get(equipmentElement.getId()), equipmentElement);
				}
			}
		}
	}

	/**
	 * 속성 생성
	 */
	private void createStatsBulk(List<EquipmentDto.CreateOrUpdateStats> createList, Equipment equipment) {
		for (EquipmentDto.CreateOrUpdateStats createStats : createList) {
			EquipmentStat stat = EquipmentDtoMapper.INSTANCE.createStat(createStats);
			stat.setEquipment(equipment);
			equipment.getEquipmentStatList().add(stat);
		}
	}

	/**
	 * 스탯 생성
	 */
	private void createElementBulk(List<EquipmentDto.CreateOrUpdateElement> createList, Equipment equipment) {
		for (EquipmentDto.CreateOrUpdateElement createElement : createList) {
			EquipmentElement element = EquipmentDtoMapper.INSTANCE.createElement(createElement);
			element.setEquipment(equipment);
			equipment.getEquipmentElementList().add(element);
		}
	}
}
