<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="logout">logout</a>
<div>User registered successfully<br>
username:${user.username}<br>
<form action="addMap" >
<label for="key">Key</label>
<input type="text" name="key" id="key"/>
<label for="value">value</label>
<input type="value" name="value" id="value"/>
<input type="submit">
</form>
<ul>
<c:forEach items="${sessionScope.map}" var="entry">
   <li> Key = ${entry.key} ---- value = ${entry.value}</li>
</c:forEach>

</ul>
</div>

</body>
</html>