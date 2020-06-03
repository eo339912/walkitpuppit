package co.dog.wp.market.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.dog.wp.common.Command;
import co.dog.wp.common.FileRenamePolicy;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;
import co.dog.wp.market.model.ReviewDAO;
import co.dog.wp.market.model.ReviewVO;


@MultipartConfig(location="c:/upload")
public class ReviewInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("UTF-8");
		//1.파라미터받기

		String seq = request.getParameter("seq");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String filename = request.getParameter("filename");
		String regdt = request.getParameter("regdt");

		//2.서비스로직처리	(DAO)
		ReviewDAO reviewDAO = new ReviewDAO();
		ReviewVO review = new ReviewVO();
		review.setSeq(seq);
		review.setId(id);
		review.setTitle(title);
		review.setContent(content);
		review.setFilename(filename);
		review.setRegdt(regdt);

		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path =  request.getSession().getServletContext().getRealPath("/upload/img");
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			review.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		reviewDAO.ReviewInsert(review);
		return "market/reviewList.jsp";
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
