<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<article>
		<header>books</header>
		<c:forEach items="${books}" var="book" }>
		<figure>
			<a href="pages/book/detail.html">
				<img src="${book.image }">
			</a>
			<footer>
				${book.name }
			</footer>
			<figcaption>
				author:${book.author} price:${book.price }
				<a href="do/cart?id=${book.id }&op=add">add to cart</a>
			</figcaption>
		</figure>
		</c:forEach>
	</article>
	
	<nav>
		<header>manage</header>
		<ul>
			<c:choose>	
			<c:when test="${user!=null }">		
			<li><a href="page/manager.jsp">welcome:${user.account}</a>	
			<li><a href="page/manager.jsp">user manage</a></li>
			<li>
				<a href="pages/manager.jsp#conent/order/order.jsp">order manage</a>
			</li>
			</c:when>
			<c:otherwise>
				<li><a href="page/login_register.jsp">login or register</a>	
			</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	
	<section>
		<header>shopping cart</header>
		<ul>
			<c:forEach items="${cart.items }" var ="item">
			<li>${item.book.name }
				<ul>
				<li>book id:${item.book.id }</li>
				<li>number:${item.quantity }</li>
				<li>summary:<f:formatNumber type="currency">${item.total }</f:formatNumber>
				<li class="operator"><a href="do/cart?id=#{item.book.id }&op=remove">delete</a></li>
				</ul>
			</li>
			</c:forEach>
		</ul>
		<footer>
			total:<f:formatNumber type="currency">${cart.total }</f:formatNumber>
		</footer>
	</section>
</body>
</html>