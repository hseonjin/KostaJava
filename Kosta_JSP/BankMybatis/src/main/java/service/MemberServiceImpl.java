package service;

import bean.Member;
import dao.MemberDAO;
import dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {

	private MemberDAO dao;
	
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
	}
	
	@Override
	public void join(Member mem) throws Exception {
		dao.join(mem);
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member member = dao.login(id);
		if(member == null) throw new Exception("아이디가 틀립니다");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호가 틀립니다");
		member.setPassword("");
		return member;
	}

	
	
}
