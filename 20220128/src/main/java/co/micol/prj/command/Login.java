package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); //세션 객체를 가져온다 , 세션의 범위는 어플리케이션 전역
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDao.memberselect(vo);
		if(vo != null) { //vo가 존재한다면
			session.setAttribute("id", vo.getId()); // 세션에 id 저장 ,값을 담아놔야 로그인이 유지됨 , id를 세션 변수로 쓰겠다
			session.setAttribute("author", vo.getAuthor());//권한을 저장
			session.setAttribute("name", vo.getName()); //이름을 저장
			request.setAttribute("message", vo.getName() + "님 환영합니다.");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/memberLoginResult";
	}

}
