package co.dog.wp.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.controller.BoardDelete;
import co.dog.wp.board.controller.BoardInsert;
import co.dog.wp.board.controller.BoardInsertForm;
import co.dog.wp.board.controller.BoardListForm;
import co.dog.wp.board.controller.BoardUpdate;
import co.dog.wp.board.controller.BoardUpdateForm;
import co.dog.wp.board.controller.BoardView;
import co.dog.wp.board.controller.BoardViewForm;
import co.dog.wp.board.controller.CommentsDelete;
import co.dog.wp.main.controller.Main;
import co.dog.wp.market.controller.CommentDelete;
import co.dog.wp.market.controller.FmarketDelete;
import co.dog.wp.market.controller.FmarketInsert;
import co.dog.wp.market.controller.FmarketInsertForm;
import co.dog.wp.market.controller.FmarketList;
import co.dog.wp.market.controller.FmarketView;
import co.dog.wp.market.controller.FmarketViewForm;
import co.dog.wp.market.controller.MarketDelete;
import co.dog.wp.market.controller.MarketInsert;
import co.dog.wp.market.controller.MarketInsertForm;
import co.dog.wp.market.controller.MarketList;
import co.dog.wp.market.controller.MarketUpdate;
import co.dog.wp.market.controller.MarketUpdateForm;
import co.dog.wp.market.controller.MarketView;
import co.dog.wp.market.controller.MarketViewForm;
import co.dog.wp.market.controller.ReviewDelete;
import co.dog.wp.market.controller.ReviewInsert;
import co.dog.wp.market.controller.ReviewInsertForm;
import co.dog.wp.market.controller.ReviewList;
import co.dog.wp.member.controller.MemberInsert;
import co.dog.wp.member.controller.MemberInsertForm;
import co.dog.wp.member.controller.MemberLogin;
import co.dog.wp.member.controller.MemberLoginForm;
import co.dog.wp.member.controller.MemberLogout;
import co.dog.wp.message.controller.MessageInsert;
import co.dog.wp.message.controller.MessageInsertForm;
import co.dog.wp.mypage.controller.Mypage;
import co.dog.wp.park.controller.ParkList;
import co.dog.wp.park.controller.ParkView;
import co.dog.wp.park.controller.ParkViewForm;
import co.dog.wp.park.controller.ParkcoDelete;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comm = null;
	
	public void init(ServletConfig config) throws ServletException {
		// 수행할 명령(command)객체의 집합 
		comm = new HashMap<String , Command>();
		comm.put("/Main.do", new Main());
		
		comm.put("/Mypage.do", new Mypage());

		comm.put("/BoardDelete.do", new BoardDelete());
		comm.put("/BoardInsertForm.do", new BoardInsertForm());
		comm.put("/BoardInsert.do", new BoardInsert());
		comm.put("/BoardList.do", new BoardListForm());
		comm.put("/BoardView.do", new BoardView());
		comm.put("/BoardViewForm.do", new BoardViewForm());
		comm.put("/BoardUpdate.do", new BoardUpdate());
		comm.put("/BoardUpdateForm.do", new BoardUpdateForm());
		comm.put("/CommentsDelete.do", new CommentsDelete());
		
		comm.put("/MemberInsert.do", new MemberInsert());
		comm.put("/MemberInsertForm.do", new MemberInsertForm());
		comm.put("/MemberLogin.do", new MemberLogin());
		comm.put("/MemberLoginForm.do", new MemberLoginForm());
		comm.put("/MemberLogout.do", new MemberLogout());
		
		comm.put("/FmarketDelete.do", new FmarketDelete());
		comm.put("/FmarketInsert.do", new FmarketInsert());
		comm.put("/FmarketInsertForm.do", new FmarketInsertForm());
		comm.put("/FmarketList.do", new FmarketList());
		comm.put("/FmarketView.do", new FmarketView());
		comm.put("/FmarketViewForm.do", new FmarketViewForm());
		
		comm.put("/MarketDelete.do", new MarketDelete());
		comm.put("/MarketInsert.do", new MarketInsert());
		comm.put("/MarketInsertForm.do", new MarketInsertForm());
		comm.put("/MarketList.do", new MarketList());
		comm.put("/MarketView.do", new MarketView());
		comm.put("/MarketViewForm.do", new MarketViewForm());
		comm.put("/MarketUpdate.do", new MarketUpdate());
		comm.put("/MarketUpdateForm.do", new MarketUpdateForm());
		comm.put("/CommentDelete.do", new CommentDelete());
		
		comm.put("/ReviewDelete.do", new ReviewDelete());
		comm.put("/ReviewList.do", new ReviewList());
		comm.put("/ReviewInsert.do", new ReviewInsert());
		comm.put("/ReviewInsertForm.do", new ReviewInsertForm());
		comm.put("/ReviewView.do", new FmarketView());
		comm.put("/ReviewViewForm.do", new FmarketViewForm());
		
		comm.put("/ParkView.do", new ParkView());
		comm.put("/ParkViewForm.do", new ParkViewForm());
		comm.put("/ParkList.do", new ParkList());
		comm.put("/ParkcoDelete.do", new ParkcoDelete());
		
		comm.put("/MessageInsert.do", new MessageInsert());
		comm.put("/MessageInsertForm.do", new MessageInsertForm());

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
