package xyz.willz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter({"/bookparking", "/confirmation.jsp", "/admin"})
public class IsLoggedIn implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.print("Is Logged? ");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("user") != null || session.getAttribute("admin") != null) {
			System.out.println("yes");
			chain.doFilter(request, response);
			return;
		}
		System.out.println("No");
		res.sendRedirect("login.jsp");
		return ;
		
	}
	 
}
