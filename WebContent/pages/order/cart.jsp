<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${cart.items }" var ="item">
		<ul class="odd">
			<li class ="id"> ${item.book.id }</li>
		</ul>
	</c:forEach>

	<form action="do/consignee" method="post">
	<ul>
		<li class="real_name">name:<input type="text" name="name"></li>
	</ul>

</body>
</html>