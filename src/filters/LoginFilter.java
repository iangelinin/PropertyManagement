package filters;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("from filter");
		String loginURL = ((HttpServletRequest) request).getContextPath() + "/not_logged.html";
		if (((HttpServletRequest) request).getSession().getAttribute("user") != null) {
			System.out.println("from if");
		    chain.doFilter(request, response); // User is logged in, just continue request.
		} else {
			System.out.println("from else");
			((HttpServletResponse) response).setContentType("text/html");
		    ((HttpServletResponse) response).sendRedirect(loginURL); // Not logged in, show login page. You can eventually show the error page instead.
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
