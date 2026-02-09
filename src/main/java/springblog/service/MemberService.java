package springblog.service;


import springblog.model.Member;

public interface MemberService {

    /**
     * 중복체크
     * 비밀번호 암호화
     * 기본 권한 설정
     * DB 저장
     * @param member
     */
    void join(Member member);

    /**
     * 로그인 ID 중복 체크
     */
    boolean isDuplicateLoginId(String loginId);

    /**
     * 이메일 중복 체크
     */
    boolean isDuplicateEmail(String email);

    /**
     * 로그인 ID로 회원 조회
     */
    Member findByLoginId(String loginId);
}
