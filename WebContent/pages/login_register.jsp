<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<article class="register">
		<form action="do/user" method="post">
			<header>user register</header>
			<input type="hidden" name="op" value="register">
			<p><label>username:</label><input name="name"/></p>
			<p><label>password:</label><input name="password" type="password"/></p>
			<p><label>re-enter password:</label><input name="confirm" type="password"/></p>
			<p><label>e-mail:</label><input name="email"/></p>
			<p><button type="button">register</button>
		</form>
	</article>
	<article class="login">
		<form action="do/user" method="post">
			<header>user login</header>
				<c:if test="${name_err != null }">
					<strong style="color:#f00">${name_err }</strong>
				</c:if>
			<input type="hidden" name="op" value="login">
			<p><label>username:</label><input name="name"/></p>
			<p><label>password:</label><input name="password" type="password"/></p>
			<p><button type="button">login</button>
		</form>
	</article>

</body>
</html>