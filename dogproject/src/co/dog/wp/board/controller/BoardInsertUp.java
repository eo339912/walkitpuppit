package co.dog.wp.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
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
 * Servlet implementation class BoardInsertUp
 */
@WebServlet("/BoardInsertUp.do")
@MultipartConfig(location="d:/upload")
public class BoardInsertUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//목록으로 페이지 이동
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = (String) request.getSession().getAttribute("loginId");

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
		String path = "D:\\dev\\git\\walkitpuppit\\dogproject\\WebContent\\upload\\img";
		//String path = getServletContext().getRealPath("Upload");
		
		//String path = request.getSession().getServletContext().getRealPath("upload/img");
		
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			board.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		boardDAO.boardInsert(board);
		
		response.sendRedirect(request.getContextPath()+ "/BoardList.do");
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
