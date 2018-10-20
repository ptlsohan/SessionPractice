<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">id</th>
      <th scope="col">name</th>
       <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${list}" var="li">
<tr>
      <th scope="row">${li.id}</th>
      <td>${li.name}</td>
      
      <td><form action="deleteStudent" method="post">
<input type="hidden" id="val" name="id" value="${li.id}"/> 
<button id="delete" class="btn btn-danger">Delete</button>
</form></td>

    </tr>
</c:forEach>
</tbody>
</table>

</body>
</html>