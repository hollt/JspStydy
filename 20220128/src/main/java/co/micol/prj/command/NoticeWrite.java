package co.micol.prj.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeWrite implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//글 등록
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		if(request.getParameter("noticeDate") != null) {
			vo.setNoticeDate(Date.valueOf(request.getParameter("noticeDate")));//형변환을 하면 date객체로 인식			
		}
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		
		String viewPage = null; //돌려줄 페이지 변수
		
		int n = noticeDao.noticeInsert(vo);
		if(n != 0) {
			viewPage = "noticeList.do"; //정상적을 등록되었으면 목록으로
		}else {
			request.setAttribute("message", "등록이 실패 했습니다.");
			viewPage = "notice/noticeError";
		}
		
		return viewPage;
	}

}
