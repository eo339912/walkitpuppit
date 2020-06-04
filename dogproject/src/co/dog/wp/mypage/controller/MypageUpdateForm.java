package co.dog.wp.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;
import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;

public class MypageUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // 파라미터 받기
		String id = (String) request.getSession().getAttribute("loginId");
			
	      // 서비스 로직처리 (회원정보 1건 조회)
		   MemberDAO memberDAO = new MemberDAO();
	    
	      MemberVO vo = memberDAO.getMember(id);
	     
	      request.setAttribute("market", vo);
	
		return "mypage/mypageUpdate.jsp";
		
	}

}
