package co.micol.prj.member.vo;

import lombok.Getter;
import lombok.Setter;

@Setter //롬복 세터 게터
@Getter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String tel;
	private String address;
	private String author;
}
