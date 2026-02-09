# 현재 작업: MemberServiceImpl 작성 (회원가입 로직)

## 🎯 지금 해야 할 일

**MemberServiceImpl 구현** (`src/main/java/springblog/service/impl/MemberServiceImpl.java`)

구현 항목:
- [ ] 회원가입 메서드 (`join()`)
  - 중복 체크 (loginId, email)
  - 비밀번호 암호화 (BCryptPasswordEncoder)
  - 기본 권한 설정 (ROLE_USER)
  - DB 저장
  - 트랜잭션 처리 (`@Transactional`)

---

## ✅ 완료된 작업 (Phase 1-3)

### Phase 1: 회원 도메인 설계
- [x] Member 엔티티 (UserDetails 구현, createdAt/updatedAt 포함)
- [x] MemberForm DTO (@NotEmpty validation)
- [x] Role enum (USER, ADMIN, GUEST)
- [x] YNTypeHandler (Boolean ↔ "Y"/"N")

### Phase 2: MyBatis 설정
- [x] MemberMapper 인터페이스 (insertMember, selectMemberByLoginId, selectMemberByEmail)
- [x] MemberMapper.xml (INSERT, SELECT 쿼리 - Leading comma 스타일)
- [x] MemberService 인터페이스

### Phase 3: DB 및 환경 설정
- [x] MEMBER 테이블 DDL (`src/main/resources/db/schema.sql`)
- [x] Spring Boot 3.5.6으로 변경 (4.0.2에서 호환성 문제 해결)
- [x] P6Spy 설정 (`spy.properties`)
- [x] application.yml (MyBatis 자동 매핑 설정)
- [x] MemberController 기본 구조 (폼 표시 및 validation)

---

## 📋 다음 단계 로드맵

1. **MemberServiceImpl 완성** ← 현재 위치
2. MemberController 연동 (Service 주입 및 호출)
3. CustomUserDetailsService 구현 (Spring Security 로그인)
4. SecurityConfig 작성 (PasswordEncoder, 로그인/로그아웃 설정)
5. 로그인/회원가입 페이지 완성

---

## 💡 중요 기술 노트

### 기술 스택
- Spring Boot 3.5.6 / MyBatis 3.0.4 / Oracle 23c / Java 17

### 명명 규칙
- **Mapper 메서드**: SQL 중심 (insertMember, selectMemberByLoginId)
- **Service 메서드**: 도메인 중심 (join, isDuplicateLoginId)
- **SQL**: Leading comma 스타일 (컬럼 앞에 쉼표)

### 코딩 컨벤션
- Builder: 생성자 레벨에 적용 (사용자 입력 필드만)
- Validation: @NotEmpty (문자열), @NotBlank (공백 체크 필요 시)
- MyBatis: 자동 매핑 활용 (map-underscore-to-camel-case: true)

### 해결된 주요 이슈
- Spring Boot 4.0.2 호환성 문제 → 3.5.6으로 다운그레이드
- @Mapper vs @MapperScan → @Mapper만 사용 (중복 제거)

---

## 📚 상세 문서

전체 진행 상황 및 상세 정보는 다음 파일 참고:
- **상세 진행 상황**: `.claude/context/PROGRESS.md`
- **최종 목표**: `.claude/context/TODO.md`
- **프로젝트 가이드**: `CLAUDE.md`
