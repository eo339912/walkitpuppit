package co.dog.wp.board.controller;

import java.io.File;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.FileRenamePolicy;


/**
 * Servlet implementation class boardInsert
 */
@WebServlet("/BoardInsert.do")
@MultipartConfig(location="d:/upload")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답결과 인코당
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청정보 인코딩
		request.setCharacterEncoding("utf-8");
		
		String id = (String) request.getSession().getAttribute("loginId");
		
//		PrintWriter out = response.getWriter();
//		if(id != "admin") {
//			out.println("<script>alert('관리자만 글쓰기 가능합니다.');</script>");
//			response.sendRedirect("/dogproject/");
//			out.flush();
//			return;
//		}
		

		// 1 파라미터 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. 서비스 로직 처리(DAO)
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = new BoardVO();
		board.setContent(content);
		board.setTitle(title);
		board.setId(id);
		
		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = "d:/upload";
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			board.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		boardDAO.boardInsert(board);
		
		response.sendRedirect(request.getContextPath() + "/BoardList.do");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);
	}
	
	//Content-Disposition: form-data; name="datafiled1"; filename="b.gif"
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
