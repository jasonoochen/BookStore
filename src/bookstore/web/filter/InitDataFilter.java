package bookstore.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import bookstore.common.ConnectionManager;
import bookstore.model.entity.Book;
import bookstore.model.service.ServiceFactory;

@WebFilter("/index.jsp")
public class InitDataFilter implements Filter {

	@Override
	public void destroy() {

	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		@SuppressWarnings("unchecked")
		List<Book> books = ServiceFactory.getService("book").findAll();
		ConnectionManager.release();
		req.setAttribute("books", books);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
