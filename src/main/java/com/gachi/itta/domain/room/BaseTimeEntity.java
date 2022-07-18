package com.gachi.itta.domain.room;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 시간 모델
 * 생성 시간, 수정 시간
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    /**
     * 생성 시간
     */
    @CreatedDate
    private LocalDateTime createdDate;
    /**
     * 마지막 수정 시간
     */
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
