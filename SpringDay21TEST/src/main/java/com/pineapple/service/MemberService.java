package com.pineapple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pineapple.repository.MemberMapper;
import com.pineapple.vo.MemberVO;

@Component
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	public void setMemberMapper(MemberMapper mapper){
		this.mapper = mapper;
	}
	
	public MemberVO choiceMemberByNum(int memberNum){
		return mapper.memberSelectByNum(memberNum);
	}
	
	public boolean loginCheck(String id, String password){
		MemberVO member = mapper.memberSelectById(id);
		if(member==null||!member.getPassword().equals(password)){
			return false;
		} else {
			return true;
		}
	}
	
	public boolean join(MemberVO member){
		if(mapper.memberInsert(member)>0){
			return true;
		} else {
			return false;
		}
	}

	public boolean idCheck(String id) {
		MemberVO member = mapper.memberSelectById(id);
		if(member==null){
			return true;
		} else {
			return false;
		}
	}
	
}
