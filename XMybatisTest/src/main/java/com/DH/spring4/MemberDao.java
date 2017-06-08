package com.DH.spring4;

import java.util.ArrayList;

public interface MemberDao {
	
	public ArrayList<Member> getMembers();
	public void insertMember(Member member);
	public void updateMember(String name);
	public void deleteMember(String name);
}
