package com.example.ghostvillageadmin.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDomainAccount implements Serializable {
//	@CreatedDate
//	@NotNull
//	@ColumnDefault("GETDATE()")
//	private LocalDateTime createdAt;
//
//	@LastModifiedDate
//	@NotNull
//	@ColumnDefault("GETDATE()")
//	private LocalDateTime updatedAt;
//
//	@CreatedBy
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Account createdBy;  //생성자
//
//	@LastModifiedBy
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Account updatedBy;  //수정자
}
