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

@MultipartConfig(location="d:/upload")
public class MarketInsert implements Command {

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
		String sselect = request.getParameter("sselect");
		String regdt = request.getParameter("regdt");
		String sell = request.getParameter("sell");
		String price = request.getParameter("price");
	
		//2.서비스로직처리	(DAO)
		MarketDAO marketDAO = new MarketDAO();
		MarketVO market = new MarketVO();
		market.setSeq(seq);
		market.setId(id);
		market.setTitle(title);
		market.setContent(content);
		market.setFilename(filename);
		market.setSselect(sselect);
		market.setRegdt(regdt);
		market.setSell(sell);
		market.setPrice(price);
		
		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = "C:\\Users\\User\\git\\walkitpuppit\\dogproject\\WebContent\\upload\\img";
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			market.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		marketDAO.MarketInsert(market);
		return "market/marketList.jsp";
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
