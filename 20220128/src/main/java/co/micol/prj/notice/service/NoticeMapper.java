package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	
	void noticeHitUpdate(int id);//조회수 증가
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("str") String str); 
	//검색할 필드와 데이터를 전달받아 검색함,맵퍼에서는 두개이상의 인자를 전달 받을떄는 파라메타로 넘어오는 값에다가 @param을 써줘야한다,써줘야 인식함
}
