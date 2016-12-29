package repository.mapper;

import vo.Member;

public interface MemberMapper {
	public int insertMember(Member member);
	public String selectId(String id);
}
