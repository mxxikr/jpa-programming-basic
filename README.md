김영한님의 [자바 ORM 표준 JPA 프로그래밍 - 기본편](https://www.inflearn.com/course/ORM-JPA-Basic/dashboard) 실습 코드 아카이브

---

### 💻 Development Environment

* Java 21
* Maven
* Database: H2
* IDE: IntelliJ

### 🏆 실습 목표
* SQL 중심적인 개발에서 객체 중심적인 개발로의 패러다임 전환 이해
* JPA의 내부 동작 원리인 영속성 컨텍스트(Persistence Context)의 메커니즘 숙지
* 객체와 관계형 데이터베이스 간의 다양한 매핑(연관관계, 상속, 값 타입) 설계 능력 배양
* 실무에서 필수적인 지연 로딩(Lazy Loading)과 객체지향 쿼리 언어(JPQL)의 기본 및 중급 문법 마스터

### 📝 Curriculum

1. **JPA 소개**
   * SQL 중심 개발의 문제점(무한 반복, 패러다임 불일치) 분석
   * JPA(Java Persistence API)의 등장 배경과 실무 저장 기술의 표준화

2. **JPA 시작하기**
   * `persistence.xml` 설정 및 `EntityManagerFactory`, `EntityManager` 구조 이해
   * 트랜잭션 내에서의 기본적인 CRUD(등록, 조회, 수정, 삭제) 애플리케이션 개발

3. **영속성 관리 - 내부 동작 방식**     
   - 영속성 컨텍스트의 핵심 이점(1차 캐시, 동일성 보장, 트랜잭션 지원 쓰기 지연, 변경 감지)
   * 플러시(Flush)의 발생 시점과 준영속 상태(Detached)의 이해
4. **엔티티 매핑**
   * 객체와 테이블 매핑(`@Entity`, `@Table`), 필드와 컬럼 매핑
   * 기본 키(Primary Key) 매핑 전략(`IDENTITY`, `SEQUENCE`, `TABLE`) 및 데이터베이스 스키마 자동 생성
   
5. **연관관계 매핑 기초**
   * 단방향 연관관계와 양방향 연관관계의 차이 이해
   * **연관관계의 주인(Owner)** 개념 정립과 양방향 매핑 시 주의사항(`mappedBy`)

6. **다양한 연관관계 매핑**

   * 다대일(`N:1`), 일대다(`1:N`), 일대일(`1:1`), 다대다(`N:M`) 매핑 구조 및 실무 적용 전략
   * `@JoinColumn`과 연관관계 편의 메서드 작성 실습
   
7. **고급 매핑**
   * 상속관계 매핑 전략(조인 전략, 단일 테이블 전략, 구현 클래스마다 테이블 전략)
   * `@MappedSuperclass`를 이용한 공통 매핑 정보 상속

8. **프록시와 연관관계 관리**

   * 프록시(Proxy) 객체의 초기화 원리와 `Member.getReference()`
   * **즉시 로딩(EAGER)과 지연 로딩(LAZY)**의 동작 방식 및 실무 권장 설정
   * 영속성 전이(CASCADE)와 고아 객체(Orphan Removal) 생명주기 관리

9. **값 타입**
   * JPA의 데이터 타입 분류(엔티티 타입 vs 값 타입)
   * 임베디드 타입(Embedded Type)과 값 타입 컬렉션, 불변 객체(Immutable Object)의 필요성

10. **객체지향 쿼리 언어1 - 기본 문법**
    * JPQL(Java Persistence Query Language)의 기본 문법 및 반환 타입
    * 프로젝션(Projection), 페이징(Paging), 조인(Join), 서브 쿼리, 조건식(CASE) 활용

11. **객체지향 쿼리 언어2 - 중급 문법**
    * 경로 표현식(상태 필드, 연관 필드)과 명시적 조인
    * **페치 조인**(Fetch Join)의 동작 원리와 N+1 문제 해결 전략
    * 엔티티 직접 사용, Named 쿼리, 벌크 연산(Bulk Operation) 최적화