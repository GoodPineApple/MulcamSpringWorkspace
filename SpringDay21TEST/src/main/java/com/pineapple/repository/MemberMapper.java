package com.pineapple.repository;

import com.pineapple.vo.MemberVO;

public interface MemberMapper {
	public int memberInsert(MemberVO member);
	public MemberVO memberSelectByNum(int memberNum);
	public MemberVO memberSelectById(String id);
}
