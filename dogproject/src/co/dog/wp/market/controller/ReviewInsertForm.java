package co.dog.wp.market.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;


public class ReviewInsertForm implements Command {
		// 응답결과 인코당

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "market/reviewInsert.jsp";
	}    


}
