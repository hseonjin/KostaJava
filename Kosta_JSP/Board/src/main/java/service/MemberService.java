package service;

import dto.Member;

public interface MemberService {
	// 로그인
	Member login(String id, String password) throws Exception;
	
	// 회원가입
	void join(Member member) throws Exception;
}
