package co.dog.wp.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command{
	public String exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	
}
