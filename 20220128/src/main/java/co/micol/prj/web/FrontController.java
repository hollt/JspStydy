package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.command.Login;
import co.micol.prj.command.LoginForm;
import co.micol.prj.command.Logout;
import co.micol.prj.command.MainCommand;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>(); //초기화
       
    
    public FrontController() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		//명령그룹
		map.put("/main.do", new MainCommand()); //Home Page  //요청,요청에대한 초기화값
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/logout.do", new Logout());
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스요청분석 및 실행
		request.setCharacterEncoding("utf-8");//한글깨짐방지
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page); //요청에 따른 적절한 수행 명령을 찾음
		String viewPage = command.exec(request, response);
		
		if(viewPage != null && !viewPage.endsWith(".do")) {//뷰페이지가 낫널이고 마지막에 .do가 포함되어있지 않다면
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";//
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
