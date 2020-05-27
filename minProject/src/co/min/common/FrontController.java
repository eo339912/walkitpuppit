package co.min.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.min.common.board.BoardGetList;
import co.min.common.commend.MainCommand;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comm = null;
	
	public void init(ServletConfig config) throws ServletException {
		// 수행할 명령(command)객체의 집합 
		comm = new HashMap<String , Command>();
		comm.put("/main.do", new MainCommand());
		comm.put("/BoardList.do", new BoardGetList());
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
