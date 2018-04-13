<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suggested Names List</title>
</head>
<body>
   <h2>
   <span class="label table-striped label-primary">User : ${name}</span>
		</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name Suggested</th>
				</tr>
			</thead>
			<tbody>	
			      <c:forEach var="item" items="${list}">	
					<tr>					    
						<td>${item.suggestedNick}</td>						
					</tr>		
			      </c:forEach>											
			</tbody>
		</table>
		<a href="user">Back</a> 
</body>
</html>
