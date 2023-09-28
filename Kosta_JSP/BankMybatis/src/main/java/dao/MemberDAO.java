package dao;

import bean.Member;

public interface MemberDAO {

	// 회원가입
	void join(Member mem) throws Exception;
	
	// 로그인
	Member login(String id) throws Exception;
}
