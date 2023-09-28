package dao;

import org.apache.ibatis.session.SqlSession;

import bean.Member;
import util.MybatisSqlSessionFactory;

public class MemberDAOImpl implements MemberDAO{
	
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	// 회원가입
	@Override
	public void join(Member mem) throws Exception {
		sqlSession.insert("mapper.member.join", mem);
		sqlSession.commit();
	}

	@Override
	public Member login(String id) throws Exception {
		Member member = sqlSession.selectOne("mapper.member.login", id);
		return member;
	}
	
}
