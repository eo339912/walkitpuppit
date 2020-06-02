package co.dog.wp.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;

/**
 * Servlet implementation class pwCheck
 */
@WebServlet("/pwCheck.do")
public class pwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pwCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터 받기
		String pwd = request.getParameter("pwd");
		
		//3. 결과를 전송
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String pwPattern = "^(?=.*[0-9])(?=.*[a-z]).{4,10}$";
		Matcher matcher = Pattern.compile(pwPattern).matcher(pwd);
		 
		if(!matcher.matches()){
			out.print("영문(대소문자 구분), 숫자, 4~10자리");
		}else {
			out.print("사용가능");
		}
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
