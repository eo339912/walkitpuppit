package co.dog.wp.park.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.park.model.WalkDAO;
import co.dog.wp.park.model.WalkVO;


public class ParkWalkIn implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			return "MemberLogin.do";
		}
		// 1 파라미터 받기
		String p_seq = request.getParameter("p_seq");
		String sname = request.getParameter("sname");
		
		// 2. 서비스 로직 처리(DAO)
		WalkDAO walkDAO = new WalkDAO();
		WalkVO walk = new WalkVO();
		walk.setId(id);
		walk.setP_seq(p_seq);
		walk.setSname(sname);
		
		walkDAO.WalkIN(walk);
		
		return "ParkViewForm.do?seq="+p_seq;
	}

}
