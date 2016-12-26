package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
/////////////////////////////////////////////////////////
	public boolean loginCheck(String id, String password){
		Member member = memberDao.select(id);
		
		if(member==null || 
				!member.getPassword().equals(password)){
			return false;
		}else{
			return true;
		}
	}
}







