package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
///////////////////////////////////////////////////////
	public boolean idCheck(String id){
		String existId = dao.selectId(id);
		
		if(existId==null || existId.length()==0)
			return true; // 사용가능한 id
		else 
			return false;// 중복된 id
	}
}



