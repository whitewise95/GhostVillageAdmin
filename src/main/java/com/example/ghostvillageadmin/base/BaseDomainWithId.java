package com.example.ghostvillageadmin.base;

import jakarta.persistence.*;
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
public abstract class BaseDomainWithId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

//    @CreatedDate
//    @NotNull
//    @ColumnDefault("CURRENT_TIMESTAMP()")
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    @NotNull
//    @ColumnDefault("CURRENT_TIMESTAMP()")
//    private LocalDateTime updatedAt;
}
