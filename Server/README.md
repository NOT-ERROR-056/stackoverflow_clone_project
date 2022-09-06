# SERVER
### > ERD 스키마 및 API 명세서는 (아래 링크 또는) 해당 repository의 Wiki 페이지를 참고해주세요.
https://github.com/NOT-ERROR-056/stackoverflow_clone_project/wiki

## 기술 적용
1. JPA 연관 매핑 및 순환참조 방지
2. 상황에 맞게 Exceptional Handling 
3. 공통된 컬럼에 __JPA Auditing__ 기술 적용

```
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime regDate;

  @LastModifiedDate
  @Column
  private LocalDateTime editDate;
}
```

4. AOP를 적용하여 효율적인 log 기록
```
@Aspect
public class LogAop {

    private static final Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Around("execution(* pre.project.api..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        logger.info("REQUEST : {}({})", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName().toString());

        Object result = joinPoint.proceed();

        long finish = System.currentTimeMillis();
        long timeMs = finish - start;

        logger.info("RESPONSE : {}({}) = {} ({}ms)", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result, timeMs);

        return result;
    }
}
```


## AWS RDS - MySQL 사용
![back1](https://user-images.githubusercontent.com/79829085/188625471-0630a0b2-1b8a-4726-b4be-3efd012d9d7e.png)

## JUNIT5, Mockito 활용한 슬라이스 및 통합 테스트
![back2](https://user-images.githubusercontent.com/79829085/188625605-ffd4f4bb-fee5-4d02-8006-e4e5f90d79d8.png)

