package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.Member;

@Component
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public boolean login(String id, String password) {
		Member savedMember = dao.selectMember(id);
		System.out.println(id);
		System.out.println(savedMember);
		if(savedMember!=null && savedMember.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
