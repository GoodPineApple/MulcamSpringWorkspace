package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;
	public void setDao(MemberDao dao){
		this.dao = dao;
	}
	
	public void memberFunc() throws Exception{
		Member member1 = new Member("ö��", "1234", "cs@cs.com", "1001");
		Member member2 = new Member("����", "1234", "yh@yg.com", "2002");
		
		System.out.println("member1:" + member1);
		dao.insert(member1);
		System.out.println("ö�� ���");
		
		if(true) {
			throw new Exception("�ǵ��� ���ܰ�ü");
		}
		
		dao.insert(member2);
		System.out.println("���� ���");
	}
}
