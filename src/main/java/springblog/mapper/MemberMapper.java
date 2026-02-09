package springblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import springblog.model.Member;

@Mapper
public interface MemberMapper {
    // 회원가입
    void insertMember(Member member);
    // 회원찾기, 로그인 ID 로 초회
    Member selectMemberByLoginId(String loginId);
    // email ID 로 조회
    Member selectMemberByEmail(String email);
}
