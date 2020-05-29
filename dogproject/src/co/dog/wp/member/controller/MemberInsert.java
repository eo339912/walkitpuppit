package co.dog.wp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;


public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 파라미터 받기		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String pbirth = request.getParameter("pbirth");
		String pgender = request.getParameter("pgender");
		String pimage = request.getParameter("pimage");
		String pname = request.getParameter("pname");

		//2. 서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setPwd(pwd);
		member.setName(name);
		member.setId(id);
		member.setPbirth(pbirth);
		member.setPgender(pgender);
		member.setPimage(pimage);
		member.setPname(pname);
		memberDAO.memberInsert(member);
		
		//3. 회원목록으로 이동 		
		//String contextPath = getServletContext().getContextPath();
		//response.sendRedirect(contextPath +"/MemberLogin.do");
		//request.getRequestDispatcher(contextPath +"/MemberLogin.do").forward(request, response);
		
		return "member/memberLogin.jsp";
	}

}
