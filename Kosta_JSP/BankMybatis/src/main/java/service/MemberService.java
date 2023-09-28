package service;

import bean.Member;

public interface MemberService {
	// 회원가입
	void join(Member mem) throws Exception;
	
	// 로그인
	Member login(String id, String password) throws Exception;
}
