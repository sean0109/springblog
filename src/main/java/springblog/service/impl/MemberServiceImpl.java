package springblog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springblog.mapper.MemberMapper;
import springblog.model.Member;
import springblog.service.MemberService;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    // 회원 가입
    @Override
    public void join(Member member) {

        // 회원 중복 로직 검증

        memberMapper.insertMember(member);
    }

    // loginId 중복 회원 검사
    @Override
    public boolean isDuplicateLoginId(String loginId) {
        return false;
    }

    // email 중복 회원 검사
    @Override
    public boolean isDuplicateEmail(String email) {
        return false;
    }

    // loginId로 회원 찾기
    @Override
    public Member findByLoginId(String loginId) {
        return null;
    }
}
