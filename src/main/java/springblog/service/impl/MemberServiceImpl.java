package springblog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springblog.dto.MemberForm;
import springblog.exception.member.MemberDuplicateException;
import springblog.mapper.MemberMapper;
import springblog.model.Member;
import springblog.model.code.Role;
import springblog.service.MemberService;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    // 회원 가입
    @Override
    @Transactional
    public void join(MemberForm form) {

        // 회원 중복 검증 로직
        isDuplicateLoginId(form.getLoginId());
        isDuplicateEmail(form.getEmail());

        // 정적 팩터리 메서드를 통한 도메인 객체 인스턴스 생성, 내부에서 builder 사용
        Member member = Member.createNewMember(form, passwordEncoder);

        memberMapper.insertMember(member);
    }

    // loginId 중복 회원 검사
    @Override
    public void isDuplicateLoginId(String loginId) {

        Member findMember = memberMapper.selectMemberByLoginId(loginId);

        if (findMember != null) {
            throw new MemberDuplicateException("이미 사용 중인 아이디입니다.", findMember.getLoginId());
        }

        //return false;
    }

    // email 중복 회원 검사
    @Override
    public void isDuplicateEmail(String email) {

        Member findMember = memberMapper.selectMemberByEmail(email);

        if (findMember != null) {
            throw new MemberDuplicateException("이미 사용 중인 이메일입니다.", findMember.getEmail());
        }

        //return false;
    }

    // loginId로 회원 찾기
    @Override
    public Member findByLoginId(String loginId) {

        return memberMapper.selectMemberByLoginId(loginId);
    }
}
