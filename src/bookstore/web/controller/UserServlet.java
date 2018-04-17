package bookstore.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.model.entity.Account;
import bookstore.model.service.ServiceFactory;

@WebServlet("/do/user")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		Account account = new Account();
		account.setAccount(name);
		account.setPassword(password);
		if("register".equals(op)) {
			doRegister(req,resp,name,account);
		}else if("login".equals(op)) {
			doLogin(req,resp,account);
		}
	}
	
	private void doLogin(HttpServletRequest req, HttpServletResponse resp, Account account) {
		List<Account> list = ServiceFactory.getService("user").findByConditions(account.getAccount());
		if(list.isEmpty() || list.get(0).getPassword().equals(account.getPassword())) {
			req.setAttribute("login_error", "username or password wrong");
			forward(req,resp,"/pages/login_register.jsp");
			return;
		}
		req.getSession().setAttribute("user", list.get(0));
		try {
			resp.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//forward(req,resp,"/pages/index.jsp");
	}

	private void doRegister(HttpServletRequest req, HttpServletResponse resp, String name, Account account) throws ServletException, IOException {
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		account.setEmail(email);
		if("".equals(name)) {
			req.setAttribute("name_err", "username is null");
			forward(req,resp,"/pages/login_register.jsp");
			return;
		}
		List<Account> list = ServiceFactory.getService("user").findByConditions(name);
		if(!list.isEmpty()) {
			req.setAttribute("name_err", "user name exist");
			forward(req,resp,"/pages/login_register.jsp");
			return;
		}
		int row = ServiceFactory.getService("user").save(account);
		req.getSession().setAttribute("user", account);
		resp.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		//forward(req,resp,"/pages/login_register.jsp");
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp,String url) {
		try {
			getServletContext().getRequestDispatcher(url).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
