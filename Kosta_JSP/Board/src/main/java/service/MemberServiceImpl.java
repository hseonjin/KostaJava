package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		memberDAO = new MemberDAOImpl();
	}

	// 로그인
	@Override
	public Member login(String id, String password) throws Exception {
		Member member = memberDAO.selectMember(id);
		if(member == null) throw new Exception("아이디 틀림");
		if(member.getPassword().equals(password) == false) throw new Exception("비밀번호 오류");
		return member;
	}
	
	// 회원가입
	@Override
	public void join(Member member) throws Exception {
		Member mem = memberDAO.selectMember(member.getId());
		if(mem != null) throw new Exception("아이디 중복 오류");
		memberDAO.insertMember(member);
	}

}
