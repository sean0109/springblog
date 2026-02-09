# TODO.md

이 문서는 springblog 프로젝트의 최종 목표를 정의한 문서입니다.

> **현재 진행 상황 및 다음 단계는 `PROGRESS.md`를 참고하세요.**

---

## 프로젝트 최종 목표

### 1. 구현
Spring Boot, MyBatis, Oracle, Thymeleaf를 사용하여 **공동 게시판 기능** 구현

**핵심 기능**:
- 회원가입 및 로그인 (Spring Security)
- 게시글 CRUD
- 댓글 기능
- 권한별 접근 제어 (USER, ADMIN)

---

### 2. 배포
**Docker 컨테이너 기반 배포**
- Oracle Database 컨테이너
- SpringBlog 애플리케이션 컨테이너
- Docker Compose로 통합 관리

---

### 3. 서비스
**AWS EC2 인스턴스 배포**
- 학습 목적: 실제 서비스 구동 확인 후 인스턴스 중지 예정

---

### 4. 배포 자동화 (CI/CD)
**GitHub Actions 활용**
- Trigger: `main` 브랜치에 Push 시
- Process:
  1. 소스 변경사항 감지
  2. 기존 애플리케이션 컨테이너 중지
  3. 새 이미지 빌드
  4. 컨테이너 재시작

---

## 기술 스택

- **Backend**: Spring Boot 3.5.6, Spring Security, MyBatis 3.0.4
- **Database**: Oracle Database 23c
- **Frontend**: Thymeleaf
- **Build**: Gradle
- **Deployment**: Docker, AWS EC2
- **CI/CD**: GitHub Actions
