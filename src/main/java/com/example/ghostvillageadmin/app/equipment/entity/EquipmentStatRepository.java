package com.example.ghostvillageadmin.app.equipment.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStatRepository extends JpaRepository<EquipmentStat, Long> {

}
