package co.dog.wp.common;

import java.io.IOException;
import java.util.ArrayList;
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
import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.main.controller.Main;
import co.dog.wp.market.controller.CommentDelete;
import co.dog.wp.market.controller.FcommentDelete;
import co.dog.wp.market.controller.FmarketDelete;
import co.dog.wp.market.controller.FmarketInsert;
import co.dog.wp.market.controller.FmarketInsertForm;
import co.dog.wp.market.controller.FmarketList;
import co.dog.wp.market.controller.FmarketUpdate;
import co.dog.wp.market.controller.FmarketUpdateForm;
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
import co.dog.wp.market.controller.McommentDelete;
import co.dog.wp.market.controller.ReviewDelete;
import co.dog.wp.market.controller.ReviewInsert;
import co.dog.wp.market.controller.ReviewInsertForm;
import co.dog.wp.market.controller.ReviewList;
import co.dog.wp.market.controller.ReviewUpdate;
import co.dog.wp.market.controller.ReviewUpdateForm;
import co.dog.wp.market.controller.ReviewView;
import co.dog.wp.market.controller.ReviewViewForm;
import co.dog.wp.market.model.ReviewDAO;
import co.dog.wp.market.model.ReviewVO;
import co.dog.wp.member.controller.MemberInsertForm;
import co.dog.wp.member.controller.MemberInsertUp;
import co.dog.wp.member.controller.MemberLogin;
import co.dog.wp.member.controller.MemberLoginForm;
import co.dog.wp.member.controller.MemberLogout;
import co.dog.wp.message.controller.MessageInsert;
import co.dog.wp.message.controller.MessageInsert2;
import co.dog.wp.message.controller.MessageInsertForm;
import co.dog.wp.message.controller.MessageInsertForm2;
import co.dog.wp.message.controller.MessageViewForm;
import co.dog.wp.message.controller.MessageViewForm2;
import co.dog.wp.message.controller.SendMessage;
import co.dog.wp.message.controller.SendView;
import co.dog.wp.mypage.controller.Myhistory;
import co.dog.wp.mypage.controller.MymarketList;
import co.dog.wp.mypage.controller.Mypage;
import co.dog.wp.mypage.controller.MypageUpdate;
import co.dog.wp.mypage.controller.MypageUpdateForm;
import co.dog.wp.mypage.controller.MyreviewList;
import co.dog.wp.mypage.controller.MywalkTime;
import co.dog.wp.park.controller.ParkList;
import co.dog.wp.park.controller.ParkView;
import co.dog.wp.park.controller.ParkViewForm;
import co.dog.wp.park.controller.ParkWalkIn;
import co.dog.wp.park.controller.ParkWalkList;
import co.dog.wp.park.controller.ParkWalkOut;
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
		comm.put("/MypageUpdate.do", new MypageUpdate());
		comm.put("/MypageUpdateForm.do", new MypageUpdateForm());
		comm.put("/Myhistory.do", new Myhistory());
		comm.put("/MymarketList.do", new MymarketList());
		comm.put("/MyreviewList.do", new MyreviewList());
		comm.put("/MywalkTime.do", new MywalkTime());

		comm.put("/BoardDelete.do", new BoardDelete());
		comm.put("/BoardInsertForm.do", new BoardInsertForm());
		comm.put("/BoardInsert.do", new BoardInsert());
		comm.put("/BoardList.do", new BoardListForm());
		comm.put("/BoardView.do", new BoardView());
		comm.put("/BoardViewForm.do", new BoardViewForm());
		comm.put("/BoardUpdate.do", new BoardUpdate());
		comm.put("/BoardUpdateForm.do", new BoardUpdateForm());
		comm.put("/CommentsDelete.do", new CommentsDelete());
		
		
		comm.put("/MemberInsertUp.do", new MemberInsertUp());
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
		comm.put("/FmarketUpdate.do", new FmarketUpdate());
		comm.put("/FmarketUpdateForm.do", new FmarketUpdateForm());
		comm.put("/FcommentDelete.do", new FcommentDelete());
		
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
		comm.put("/ReviewView.do", new ReviewView());
		comm.put("/ReviewViewForm.do", new ReviewViewForm());
		comm.put("/ReviewUpdate.do", new ReviewUpdate());
		comm.put("/ReviewUpdateForm.do", new ReviewUpdateForm());
		comm.put("/McommentDelete.do", new McommentDelete());
	
		
		comm.put("/ParkView.do", new ParkView());
		comm.put("/ParkViewForm.do", new ParkViewForm());
		comm.put("/ParkList.do", new ParkList());
		comm.put("/ParkcoDelete.do", new ParkcoDelete());

		comm.put("/ParkWalkIn.do", new ParkWalkIn());
		comm.put("/ParkWalkOut.do", new ParkWalkOut());
		comm.put("/ParkWalkList.do", new ParkWalkList());
		
		comm.put("/MessageInsert.do", new MessageInsert());
		comm.put("/MessageInsertForm.do", new MessageInsertForm());
		comm.put("/MessageViewForm.do", new MessageViewForm());
		comm.put("/SendMessage.do", new SendMessage());
		comm.put("/SendView.do", new SendView());
		comm.put("/MessageViewForm2.do", new MessageViewForm2());
		comm.put("/MessageInsertForm2.do", new MessageInsertForm2());
		comm.put("/MessageInsert2.do", new MessageInsert2());

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
		
		//footer
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardVO> boardlist = boardDAO.getBoardList();
		request.setAttribute("footerBoard", boardlist);
		
		ReviewDAO reviewDAO = new ReviewDAO();
		ArrayList<ReviewVO> reviewlist = reviewDAO.getReviewList();
		request.setAttribute("footerReview", reviewlist);
		
		
		
		String viewPage = subCommand.exec(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
