package co.dog.wp.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.dog.wp.common.Command;
import co.dog.wp.common.FileRenamePolicy;
import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;


public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 파라미터 받기		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String thumd = request.getParameter("thumd");

		//2. 서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setPwd(pwd);
		member.setName(name);
		member.setId(id);
		member.setThumd(thumd);
		
		//첨부파일 처리
		Part part = request.getPart(thumd);
		String fileName = getFileName(part);
		String path = request.getSession().getServletContext().getRealPath("thumd");
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			member.setThumd(f.getName()); //파일명을 vo에 담기
		}
				
		memberDAO.memberInsert(member);
		
		//3. 회원목록으로 이동 		
		//String contextPath = getServletContext().getContextPath();
		//response.sendRedirect(contextPath +"/MemberLogin.do");
		//request.getRequestDispatcher(contextPath +"/MemberLogin.do").forward(request, response);
		
		return "member/memberLogin.jsp";
	}
	
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
