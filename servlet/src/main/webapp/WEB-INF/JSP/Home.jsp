<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Premiere JSP</title>
</head>
<body>
		<h1>Premiere JSP</h1>
		<%@ include file="/WEB-INF/JSP/Components/menu.jsp" %>
		<p>Premiere JSP</p>
		<p>Salutation ${ nom }</p>
		
		<h2>Utilisation des tags d'expression</h2>
		<%
			String nom = (String) request.getAttribute("nom");
			if(nom != null){
				out.println("<p>Salutation " + nom + "</p>");
			}	
		%>
</body>
</html>