package co.dog.wp.market.controller;

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

import co.dog.wp.common.Command;
import co.dog.wp.common.FileRenamePolicy;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;

@WebServlet("/MarketUpdate.do")
@MultipartConfig(location="c:/upload")
public class MarketUpdate extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	
	public MarketUpdate() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//목록으로 페이지 이동
			request.getRequestDispatcher("/market/marketUpdate.jsp").forward(request, response);
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			
			// 1 파라미터 받기		
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String filename = request.getParameter("filename");
			String sselect = request.getParameter("sselect");
			String regdt = request.getParameter("regdt");
			String sell = request.getParameter("sell");
			String price = request.getParameter("price");
			
			// 2. 서비스 로직 처리(DAO)
			MarketDAO marketDao = new MarketDAO();
			MarketVO market = new MarketVO();
			market.setContent(content);
			market.setTitle(title);
			market.setSeq(seq);
			market.setSselect(sselect);
			market.setRegdt(regdt);
			market.setSell(sell);
			market.setPrice(price);
			market.setFilename(filename);
			
			
			
			
			//첨부파일 처리
			Part part = request.getPart("filename");
			String fileName = getFileName(part);
			String path = request.getSession().getServletContext().getRealPath("/upload/img");
			
			
			if(fileName != null && !fileName.isEmpty()) {
				File f = FileRenamePolicy.rename(new File(path, fileName));
				part.write(f.getAbsolutePath()); //업로드 폴더에 파일 저장 ,전체파일이름명
				market.setFilename(f.getName()); //파일명을 vo에 담기
			}
					
			marketDao.marketUpdate(market);
			response.sendRedirect(request.getContextPath()+ "/MarketList.do");
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
			
			return null;
	}

}
