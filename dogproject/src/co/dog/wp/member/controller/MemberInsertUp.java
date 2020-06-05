package co.dog.wp.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.dog.wp.common.Command;
import co.dog.wp.common.FileRenamePolicy;
import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;

/**
 * Servlet implementation class BoardInsertUp
 */
@WebServlet("/MemberInsertUp.do")
@MultipartConfig(location="c:/upload")
public class MemberInsertUp extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//목록으로 페이지 이동
		request.getRequestDispatcher("/market/memberInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwdcf = request.getParameter("pwdcf");
		String name = request.getParameter("name");
		String pwckok = request.getParameter("pwckok");

	
		// 2. 서비스 로직 처리(DAO)
	
		//2. 서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setPwd(pwd);
		member.setName(name);
		member.setId(id);
		
		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path =  request.getSession().getServletContext().getRealPath("/upload/img");
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			member.setThumd(f.getName()); //파일명을 vo에 담기
		}
				
		System.out.println(pwckok);
		PrintWriter out = response.getWriter();
		if( !pwckok.isEmpty()) {
			int ok = memberDAO.memberInsert(member);
			if(ok == 1) {
				out.println("<script>alert('계정이 등록 되었습니다'); location.href='MemberLoginForm.do';</script>");							
			}else if(ok != 1){
				out.println("<script>alert('존재하는 아이디입니다.'); location.href='MemberInsertForm.do';</script>");						
			}
		}else if(pwckok.isEmpty()){
			out.println("<script>alert('비밀번호를 확인해주세요'); location.href='MemberInsertForm.do';</script>");						
		}
			
		out.flush();
		
		//response.sendRedirect(request.getContextPath()+ "/MemberInsertForm.do?ok=1");
	}
	
	
	
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
