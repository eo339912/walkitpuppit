package co.dog.wp.park.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.park.model.WalkDAO;
import co.dog.wp.park.model.WalkVO;


public class ParkWalkList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_seq = request.getParameter("seq");
		
		WalkDAO walkdao = new WalkDAO();
		ArrayList<WalkVO> walkList = walkdao.getWalkList(p_seq);
		
		request.setAttribute("walkList", walkList); 
		
		return "park/walkList.jsp";
	}

}
