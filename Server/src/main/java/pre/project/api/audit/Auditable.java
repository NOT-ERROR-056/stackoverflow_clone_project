package pre.project.api.audit;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * # JPA Auditing
 * 도메인을 관계형 데이터베이스 테이블에 매핑할 때 공통적으로 가지고 있는 필드(컬럼)를 매핑
 * 주로 entity 생성 시간, 수정 시간 적용
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

    // Entity 가 생성되어 db에 저장될 때 시간이 자동으로 저장
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    // 조회한 Entity 의 값을 변경할 때 시간이 자동으로 저장
    @LastModifiedDate
    @Column
    private LocalDateTime editDate;
}
