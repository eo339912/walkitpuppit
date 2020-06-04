package co.dog.wp.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;

public class Myhistory implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		
		//서비스로직
		
		//
		return "mypage/myhistory.jsp";
	}

}
