package co.dog.wp.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.Command;
import co.dog.wp.common.FileRenamePolicy;

@MultipartConfig(location="d:/upload")
public class BoardInsert  implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		String path = "D:\\dev\\git\\walkitpuppit\\dogproject\\WebContent\\upload";
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			board.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		boardDAO.boardInsert(board);
		
		return "board/boardList.jsp";
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
