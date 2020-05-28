package co.dog.wp.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.controller.BoardDelete;
import co.dog.wp.board.controller.BoardInsert;
import co.dog.wp.board.controller.BoardInsertForm;
import co.dog.wp.board.controller.BoardListForm;
import co.dog.wp.board.controller.BoardView;
import co.dog.wp.board.controller.BoardViewForm;
import co.dog.wp.board.controller.CommentsDelete;
import co.dog.wp.market.controller.FmarketInsert;
import co.dog.wp.market.controller.FmarketInsertForm;
import co.dog.wp.market.controller.FmarketList;
import co.dog.wp.market.controller.MarketInsert;
import co.dog.wp.member.controller.MemberInsert;
import co.dog.wp.member.controller.MemberInsertForm;
import co.dog.wp.member.controller.MemberLogin;
import co.dog.wp.member.controller.MemberLoginForm;
import co.dog.wp.member.controller.MemberLogout;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comm = null;
	
	public void init(ServletConfig config) throws ServletException {
		// 수행할 명령(command)객체의 집합 
		comm = new HashMap<String , Command>();
		comm.put("/BoardDelete.do", new BoardDelete());
		comm.put("/BoardInsertForm.do", new BoardInsertForm());
		comm.put("/BoardInsert.do", new BoardInsert());
		comm.put("/BoardList.do", new BoardListForm());
		comm.put("/BoardView.do", new BoardView());
		comm.put("/BoardViewForm.do", new BoardViewForm());
		comm.put("/CommentsDelete.do", new CommentsDelete());
		
		comm.put("/MemberInsert.do", new MemberInsert());
		comm.put("/MemberInsertForm.do", new MemberInsertForm());
		comm.put("/MemberLogin.do", new MemberLogin());
		comm.put("/MemberLoginForm.do", new MemberLoginForm());
		comm.put("/MemberLogout.do", new MemberLogout());
		
		comm.put("/FmarketInsert.do", new FmarketInsert());
		comm.put("/FmarketInsertForm.do", new FmarketInsertForm());
		comm.put("/FmarketInsert.do", new FmarketInsert());
		comm.put("/FmarketList.do", new FmarketList());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 적절한 수행할 명령(command) 객체를 찾음
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Command subCommand = comm.get(path);
		
		String viewPage = subCommand.exec(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
