package co.dog.wp.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");

		resp.setContentType("text/html; charset=euc-kr");

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");

		String contentType = req.getContentType();
		if (contentType != null
				&& contentType.toLowerCase().startsWith("multipart/")) {
			printPartInfo(req, writer);
		} else {
			writer.println("multipart");
		}
		writer.println("</body></html>");
		writer.flush();
		writer.close();
	}

	private void printPartInfo(HttpServletRequest req, PrintWriter writer)
			throws IOException, ServletException {
		String folder = "D:/upload/";
		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			writer.println("<br/> name = " + part.getName());
			String contentType = part.getContentType();
			writer.println("<br/> contentType = " + contentType);
			if (contentType != null && contentType.startsWith("application/")) {
				long size = part.getSize();
				writer.println("<br/> size = " + size);
				String fileName = getFileName(part);
				writer.println("<br/> filename = " + fileName);

				if (size > 0) {
					part.write(folder + fileName);
					part.delete();
				}
			} else {
				String value = readParameterValue(part);
				writer.println("<br/> value = " + value);
			}
			writer.println("<hr/>");
		}
	}

	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	private String readParameterValue(Part part)
			throws IOException {
		InputStreamReader reader = 
				new InputStreamReader(part.getInputStream(), "euc-kr");
		char[] data = new char[512];
		int len = -1;
		StringBuilder builder = new StringBuilder();
		while ((len = reader.read(data)) != -1) {
			builder.append(data, 0, len);
		}
		return builder.toString();
	}

}
