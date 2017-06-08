package com.DH.spring4;

import java.util.ArrayList;

import com.DH.spring4.Member;

public interface MemberMapper {
	
	ArrayList<Member> getMembers();
	void insertMember(Member member);
	void updateMember(String name);
	void deleteMember(String name);
}
