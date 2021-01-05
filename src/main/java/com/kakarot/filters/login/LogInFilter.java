package com.kakarot.filters.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.kakarot.CredidentialsCheck;

@WebFilter(urlPatterns = {"/home" , "/homeView.jsp"})
public class LogInFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CredidentialsCheck cc = new CredidentialsCheck();
		HttpServletResponse res = (HttpServletResponse) response;

		if (!cc.check(request.getParameter("username"), request.getParameter("password")))
			res.sendRedirect("index.jsp");
		else
			chain.doFilter(request, response);
	}

}
