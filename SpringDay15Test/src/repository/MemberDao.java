package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MemberMapper;
import vo.Member;

@Component
public class MemberDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public Member selectMember(String id) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		System.out.println(id + ", " + mapper.selectMember(id));
		return mapper.selectMember(id);
	}

}
