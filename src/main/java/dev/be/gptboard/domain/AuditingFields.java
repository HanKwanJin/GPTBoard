package dev.be.gptboard.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingFields {

    @CreatedDate
    @DateTimeFormat(iso = ISO.DATE_TIME)
    protected LocalDateTime createdAt;

    @CreatedBy
    protected String createdBy;

    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt;

    @LastModifiedBy
    protected String modifiedBy;
}