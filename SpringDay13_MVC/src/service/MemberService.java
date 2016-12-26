package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	public MemberService(MemberDao dao){
		this.dao = dao;
	}
	
	public MemberService(){
	}
	
	public boolean join(Member member){
		if(dao.insert(member) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
