package dao;

import dto.Member;

public interface MemberDAO {
	// 회원 선택
	Member selectMember(String id) throws Exception;
	
	// 회원 등록
	void insertMember(Member member) throws Exception;
}
