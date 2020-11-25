package com.gil.springboot.service.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // if some class extend this class, field that made this class is be column.
@EntityListeners((AuditingEntityListener.class)) // add Auditing function
public abstract class BaseTimeEntity {

    @CreatedDate // Time will save when make a entity and save
    private LocalDateTime createDate;

    @LastModifiedDate // Time will save when modify the entity
    private LocalDateTime modifiedDate;
}
