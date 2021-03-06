package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.MemberMapper;
import vo.Member;

@Component
public class MemberDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSqlsessionTemplate(SqlSessionTemplate session){
		this.session = session;
	}
	
	public int insertMember(Member member){
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.insertMember(member);
	}
	
	public Member selectMember(String id){
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectMember(id);
	}
	
}
