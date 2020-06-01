package co.dog.wp.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dog.wp.common.Command;
import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;

public class MemberLogin implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2. 서비스 로직 
		//단건조회
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//id.조회 결과없으면 id가 없다.
		//id.조회 결과있으면 pwd가 맞는지 검사 후 로그인 -> 틀리면 오류 
		if(vo.getId() == null) { //id오류
			out.print("id 오류");
		}else if(!vo.getPwd().equals(pwd)) { //pwd오류
			out.print("pwd 오류");
		}else { //login ok
			//세션에 로그인 여부를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("loginMember", vo);
			
			//String ContextPath= request.getContextPath();
			//response.sendRedirect(ContextPath + "/");
			
		}
		return "/";
		
		
	}

}