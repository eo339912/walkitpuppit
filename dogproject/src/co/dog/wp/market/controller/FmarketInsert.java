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
public class FmarketInsert implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//응답결과 인코딩 - utf-8형식으로 변환. -> 한글 안 깨지게
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("UTF-8");

		String seq = request.getParameter("seq");
		String id = request.getParameter("id");
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");
		String filename = request.getParameter("filename");
		String fsselect = request.getParameter("fsselect");
		String fregdt = request.getParameter("fregdt");
		String fsell = request.getParameter("fsell");
		String fprice = request.getParameter("fprice");

	
		//2.서비스로직처리	(DAO)
		MarketDAO marketDAO = new MarketDAO();
		MarketVO market = new MarketVO();
		market.setSeq(seq);
		market.setId(id);
		market.setFtitle(ftitle);
		market.setFcontent(fcontent);
		market.setFilename(filename);
		market.setFsselect(fsselect);
		market.setFregdt(fregdt);
		market.setFsell(fsell);
		market.setFprice(fprice);
		
		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = request.getSession().getServletContext().getRealPath("/upload/img");
		if(fileName != null && !fileName.isEmpty()) {
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
			market.setFilename(f.getName()); //파일명을 vo에 담기
		}
				
		marketDAO.FmarketInsert(market);
		return "market/fmarketList.jsp";
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
