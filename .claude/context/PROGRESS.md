# PROGRESS.md

> **이 문서는 현재 진행 중인 작업 상황을 기록합니다.**
> 최종 목표는 `TODO.md`를 참고하세요.

**마지막 업데이트**: 2026-02-09

---

## 🎯 현재 작업 중

### MemberServiceImpl 작성 (2단계)

**위치**: `src/main/java/springblog/service/impl/MemberServiceImpl.java`

**구현해야 할 내용**:
- [ ] 회원가입 처리 (`join()`)
- [ ] 중복 체크 (`isDuplicateLoginId`, `isDuplicateEmail`)
- [ ] 비밀번호 암호화 (BCryptPasswordEncoder)
- [ ] 기본 권한 설정 (ROLE_USER)
- [ ] 트랜잭션 처리 (`@Transactional`)

---

## ✅ 완료된 작업

### Phase 1: 회원 도메인 설계 및 DB 구성
- [x] Member 엔티티 작성 (UserDetails 구현)
  - `src/main/java/springblog/model/Member.java`
  - Spring Security UserDetails 인터페이스 구현
  - Role enum 연동
  - 계정 상태 필드 (accountNonExpired, accountNonLocked 등)
  - createdAt, updatedAt 추가

- [x] MemberForm DTO 작성 (Validation)
  - `src/main/java/springblog/dto/MemberForm.java`
  - @NotEmpty validation 추가
  - 회원가입 폼 데이터 바인딩용

- [x] Role enum 작성
  - `src/main/java/springblog/model/code/Role.java`
  - USER, ADMIN, GUEST

- [x] MEMBER 테이블 DDL 작성
  - `src/main/resources/db/schema.sql`
  - Oracle Database 기준
  - 시퀀스 포함 (SEQ_MEMBER_ID)

- [x] YNTypeHandler 작성
  - `src/main/java/springblog/config/YNTypeHandler.java`
  - MyBatis TypeHandler: Boolean ↔ "Y"/"N" 변환

### Phase 2: MyBatis 설정
- [x] MemberMapper 인터페이스 작성
  - `src/main/java/springblog/mapper/MemberMapper.java`
  - insertMember, selectMemberByLoginId, selectMemberByEmail

- [x] MemberMapper.xml 작성
  - `src/main/resources/mapper/MemberMapper.xml`
  - INSERT, SELECT 쿼리 (Leading comma 스타일)
  - 자동 매핑 활용 (map-underscore-to-camel-case)

- [x] MemberService 인터페이스 작성
  - `src/main/java/springblog/service/MemberService.java`

### Phase 3: 환경 설정
- [x] Spring Boot 버전 호환성 문제 해결
  - 4.0.2 → 3.5.6으로 다운그레이드
  - MyBatis 3.0.4와 호환성 확보

- [x] P6Spy 설정 파일 추가
  - `src/main/resources/spy.properties`
  - SQL 로깅 설정

- [x] application.yml 설정
  - MyBatis mapper-locations, type-aliases-package
  - map-underscore-to-camel-case: true

- [x] MemberController 기본 구조
  - `src/main/java/springblog/controller/MemberController.java`
  - 회원가입 폼 표시 및 validation 처리

---

## 📋 다음 단계 로드맵

### 1단계: MemberServiceImpl 완성 ← **현재 위치**
- MemberServiceImpl 작성
- 단위 테스트 (선택)

### 2단계: MemberController 연동
- MemberController에서 MemberService 주입
- 회원가입 로직 연결
- 성공/실패 처리

### 3단계: Spring Security 설정
- CustomUserDetailsService 구현
  - UserDetailsService 인터페이스 구현
  - loadUserByUsername() 메서드 - DB에서 Member 조회

- SecurityConfig 작성
  - PasswordEncoder Bean (BCrypt)
  - 로그인/로그아웃 설정
  - URL 접근 제어 (/members/new는 permitAll 등)
  - CSRF 설정

### 4단계: 로그인/회원가입 페이지 완성
- 회원가입 페이지 (signUpForm.html) 검증
- 로그인 페이지 작성
- 에러 메시지 표시
- Thymeleaf Security 적용

### 5단계: 테스트 및 검증
- 회원가입 기능 통합 테스트
- 로그인 기능 테스트
- 권한별 접근 제어 테스트

---

## 💡 중요 참고사항

### 기술 스택
- **Spring Boot**: 3.5.6
- **MyBatis**: 3.0.4
- **Oracle Database**: 23c (FREEPDB1)
- **Java**: 17

### 프로젝트 구조
```
springblog/
├── src/main/java/springblog/
│   ├── config/          # 설정 클래스
│   ├── controller/      # 컨트롤러
│   ├── dto/             # DTO
│   ├── mapper/          # MyBatis Mapper 인터페이스
│   ├── model/           # 엔티티, Enum
│   └── service/         # 서비스 (인터페이스 + 구현체)
├── src/main/resources/
│   ├── db/              # DDL 스크립트
│   ├── mapper/          # MyBatis XML
│   ├── static/          # CSS, JS
│   └── templates/       # Thymeleaf HTML
```

### 명명 규칙
- **Mapper 메서드**: SQL 중심 (insertMember, selectMemberByLoginId)
- **Service 메서드**: 도메인 중심 (join, isDuplicateLoginId)
- **SQL**: Leading comma 스타일 사용

### 코딩 컨벤션
- Builder 패턴: 생성자 레벨에 적용 (사용자 입력 필드만 포함)
- Validation: @NotEmpty (문자열), @NotBlank (공백 체크 필요 시)
- MyBatis: 자동 매핑 활용 (resultType="Member")

---

## 🔧 해결된 주요 이슈

1. **Spring Boot 4.0.2 호환성 문제**
   - 증상: MyBatis sqlSessionFactory 빈을 찾을 수 없음
   - 해결: Spring Boot 3.5.6으로 다운그레이드

2. **@Mapper vs @MapperScan**
   - 결론: @Mapper 어노테이션만 사용 (springshop 프로젝트와 동일)
   - @MapperScan 제거 (중복)

3. **Leading Comma 스타일**
   - SQL 쿼리의 컬럼 앞에 쉼표 위치
   - 주석 처리 용이, Git Diff 깔끔

---

## 📝 메모

- DB 테이블은 이미 생성됨 (DBeaver에서 실행 완료)
- P6Spy를 통한 SQL 로깅 활성화
- 회원가입 폼 validation 작동 확인 완료
