package service;

import dto.Member;

public interface MemberService {
	// 로그인
	Member login(String id, String password) throws Exception;
	
	// 회원가입
	void join(Member member) throws Exception;

	// 아이디 중복체크
	String isCheckId(String id) throws Exception;
}
