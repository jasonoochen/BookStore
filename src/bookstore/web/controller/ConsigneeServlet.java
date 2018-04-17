package bookstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.model.entity.Consignee;

@WebServlet("/do/consignee")
public class ConsigneeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String street = req.getParameter("street");
		Consignee csn = new Consignee();
		csn.setCity(city);
		csn.setName(name);
		csn.setProvince(province);
		csn.setStreet(street);
		csn.setTel(tel);
	}
	
}
