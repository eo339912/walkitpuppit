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
import co.dog.wp.common.Command;
import co.dog.wp.common.FileRenamePolicy;

@WebServlet("/BoardUpdate.do")
@MultipartConfig(location="d:/upload")
public class BoardUpdate extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	
    public BoardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//목록으로 페이지 이동
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 1 파라미터 받기		
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		// 2. 서비스 로직 처리(DAO)
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = new BoardVO();
		board.setContent(content);
		board.setTitle(title);
		board.setSeq(seq);
		
		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = request.getSession().getServletContext().getRealPath("/upload/img");
		
		
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			board.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		boardDao.boardUpdate(board);
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

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


}

