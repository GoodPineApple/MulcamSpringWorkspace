package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	public void setMemberDao (MemberDao dao){
		this.dao = dao;
	}
	
	public boolean loginCheck(String id, String password){
		Member member = dao.selectMember(id);
		if(member==null||!member.getPassword().equals(password)){
			return false;
		} else {
			return true;
		}
	}
	
	public boolean join(Member member){
		System.out.println(member);
		if(dao.insertMember(member)>0){
			return true;
		} else {
			return false;
		}
	}
	
}
