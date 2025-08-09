<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.test.data.Livre" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h2>List des produits</h2>
	<%@ include file="/WEB-INF/JSP/Components/menu.jsp" %>
	<p>List des produits</p>
	
	<%
		
	List<Livre> livres = (List<Livre>) request.getAttribute("livres");
	for(Livre livre : livres){
		out.print("<p>Titre : " + livre.getTitle() + " </br> Auteur : " + livre.getAuthor() + " </br> Prix : " + livre.getPrice() + "FCFA </p>");
	}
	
	%>
</body>
</html>