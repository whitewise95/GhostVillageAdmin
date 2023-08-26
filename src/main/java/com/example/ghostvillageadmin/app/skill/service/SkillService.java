package com.example.ghostvillageadmin.app.skill.service;

import com.example.ghostvillageadmin.app.skill.domain.Skill;
import com.example.ghostvillageadmin.app.skill.domain.SkillOption;
import com.example.ghostvillageadmin.app.skill.domain.SkillRepository;
import com.example.ghostvillageadmin.app.skill.domain.SkillStats;
import com.example.ghostvillageadmin.app.skill.domain.enums.SkillOptionType;
import com.example.ghostvillageadmin.app.skill.dto.SkillDto;
import com.example.ghostvillageadmin.app.skill.dto.SkillDtoMapper;
import com.example.ghostvillageadmin.app.utils.PagableDto;
import com.example.ghostvillageadmin.exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.List;
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
public class SkillService {

	private final SkillRepository skillRepository;

	/**
	 * 스킬 목록 조회
	 */
	public PagableDto.Response<SkillDto.Response> getSkillList(PagableDto.Request request) {
		Sort sort = Sort.by(request.getOrderType().dir, request.getSortField());

		Pageable pageRequest = PageRequest.of(request.getPage(), request.getLimit(), sort);
		Page<Skill> skillList = skillRepository.findAll(pageRequest);

		return PagableDto.Response.of(skillList,
									  skillList.stream()
											   .map(SkillDtoMapper.INSTANCE::toResponse)
											   .toList());
	}

	/**
	 * 스킬 상세 조회
	 */
	public SkillDto.DetailResponse getSkill(Long id) {
		Skill skill = skillRepository.findById(id).orElseThrow(() -> new NotFoundException("스킬", true));
		SkillDto.DetailResponse detailResponse = SkillDtoMapper.INSTANCE.toDetailResponse(skill);

		for (SkillOption skillOption : skill.getSkillOptionList()) {
			switch (skillOption.getType()) {
				case SCOPE -> {
					detailResponse.setSize(skillOption.getOptionValue());
					detailResponse.setSizeAdd(skillOption.getUpdateValue());
				}
				case COOL_TIME -> {
					detailResponse.setCool(skillOption.getOptionValue());
					detailResponse.setCoolDec(skillOption.getUpdateValue());
				}
				case MANA_DOWN -> {
					detailResponse.setMana(skillOption.getOptionValue());
					detailResponse.setManaDec(skillOption.getUpdateValue());
				}
				case EXP_COUNT -> {
					detailResponse.setExpCount((Math.round(skillOption.getOptionValue())));
					detailResponse.setExpAdd((Math.round(skillOption.getUpdateValue())));
				}
				case DURATION -> {
					detailResponse.setTime(skillOption.getOptionValue());
					detailResponse.setTimeAdd(skillOption.getUpdateValue());
				}
			}
		}

		for (SkillStats skillStats : skill.getSkillStatsList()) {
			switch (skillStats.getSortNum()) {
				case 1 -> {
					detailResponse.setValue1(skillStats.getStatsValue());
					detailResponse.setValue1Add(skillStats.getUpdateValue());
				}
				case 2 -> {
					detailResponse.setValue2(skillStats.getStatsValue());
					detailResponse.setValue2Add(skillStats.getUpdateValue());
				}
				case 3 -> {
					detailResponse.setValue3(skillStats.getStatsValue());
					detailResponse.setValue3Add(skillStats.getUpdateValue());
				}
				case 4 -> {
					detailResponse.setValue4(skillStats.getStatsValue());
					detailResponse.setValue4Add(skillStats.getUpdateValue());
				}
			}
		}

		return detailResponse;
	}

	/**
	 * 스킬 생성
	 */
	@Transactional
	public SkillDto.DetailResponse create(SkillDto.Create create) {
		Skill skill = SkillDtoMapper.INSTANCE.create(create);
		skill.getSkillStatsList().addAll(createSkillStatsList(create, skill));
		skill.getSkillOptionList().addAll(createSkillOptionList(create, skill));
		skillRepository.save(skill);
		return null;
	}

	/**
	 * 스킬 수정
	 * */
	@Transactional
	public void update(SkillDto.Update update, Long id) {
		Skill skill = skillRepository.findById(id).orElseThrow(() -> new NotFoundException("스킬", true));
		SkillDtoMapper.INSTANCE.update(update, skill);

		for (SkillOption skillOption : skill.getSkillOptionList()) {
			switch (skillOption.getType()) {
				case SCOPE -> {
					skillOption.setOptionValue(update.getSize());
					skillOption.setUpdateValue(update.getSizeAdd());
				}
				case COOL_TIME -> {
					skillOption.setOptionValue(update.getCool());
					skillOption.setUpdateValue(update.getCoolDec());
				}
				case MANA_DOWN -> {
					skillOption.setOptionValue(update.getMana());
					skillOption.setUpdateValue(update.getManaDec());
				}
				case EXP_COUNT -> {
					skillOption.setOptionValue(Float.valueOf(update.getExpCount()));
					skillOption.setUpdateValue(Float.valueOf(update.getExpAdd()));
				}
				case DURATION -> {
					skillOption.setOptionValue(update.getTime());
					skillOption.setUpdateValue(update.getTimeAdd());
				}
			}
		}

		for (SkillStats skillStats : skill.getSkillStatsList()) {
			switch (skillStats.getSortNum()) {
				case 1 -> {
					skillStats.setStatsValue(update.getValue1());
					skillStats.setUpdateValue(update.getValue1Add());
				}
				case 2 -> {
					skillStats.setStatsValue(update.getValue2());
					skillStats.setUpdateValue(update.getValue2Add());
				}
				case 3 -> {
					skillStats.setStatsValue(update.getValue3());
					skillStats.setUpdateValue(update.getValue3Add());
				}
				case 4 -> {
					skillStats.setStatsValue(update.getValue4());
					skillStats.setUpdateValue(update.getValue4Add());
				}
			}
		}
	}

	@Transactional
	public void delete(Long id) {
		Skill skill = skillRepository.findById(id).orElseThrow(() -> new NotFoundException("스킬", true));
		skillRepository.delete(skill);
	}

	/**
	 * 스킬 옵션 생성
	 */
	private List<SkillOption> createSkillOptionList(SkillDto.Create create, Skill skill) {
		List<SkillOption> skillOptionList = new ArrayList<>();
		skillOptionList.add(SkillOption.creeateSkillOption(create.getCool(), create.getCoolDec(), SkillOptionType.COOL_TIME, skill));
		skillOptionList.add(SkillOption.creeateSkillOption(create.getTime(), create.getTimeAdd(), SkillOptionType.DURATION, skill));
		skillOptionList.add(SkillOption.creeateSkillOption(create.getSize(), create.getSizeAdd(), SkillOptionType.SCOPE, skill));
		skillOptionList.add(SkillOption.creeateSkillOption(create.getMana(), create.getManaDec(), SkillOptionType.MANA_DOWN, skill));
		skillOptionList.add(SkillOption.creeateSkillOption(Float.valueOf(create.getExpCount()), Float.valueOf(create.getExpAdd()), SkillOptionType.EXP_COUNT, skill));
		return skillOptionList;
	}

	/**
	 * 능력치 생성
	 */
	private List<SkillStats> createSkillStatsList(SkillDto.Create create, Skill skill) {
		List<SkillStats> skillStatsList = new ArrayList<>();
		skillStatsList.add(SkillStats.createSkillStats(create.getValue1(), create.getValue1Add(), 1, skill));
		skillStatsList.add(SkillStats.createSkillStats(create.getValue2(), create.getValue2Add(), 2, skill));
		skillStatsList.add(SkillStats.createSkillStats(create.getValue2(), create.getValue3Add(), 3, skill));
		skillStatsList.add(SkillStats.createSkillStats(create.getValue2(), create.getValue4Add(), 4, skill));
		return skillStatsList;
	}
}
