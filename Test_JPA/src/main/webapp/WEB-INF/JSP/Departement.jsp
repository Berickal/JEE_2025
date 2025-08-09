<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.test.entities.Personne,com.test.entities.Departement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Departement</h1>

<h2>Ajouter un departement</h2>
<form method="POST" action="Departement">

	<input type="hidden" value="${ !empty target ? target.id : -1 }" />
	<label for="nom">Nom</label>
	<input type="text" id="nom" name="nom" value="${ !empty target ? target.nom : null }"/>
	
	<input type="submit" />
</form>

<h2>Tous les departement</h2>
<ul>
	<%
		List<Departement> dp = (List<Departement>) request.getAttribute("departement");
		for(Departement d : dp){
			out.print("<li> <a href=\"http://localhost:8080/Test_JPA/Departement?id=" + d.getId() + "\"/>" + d.getNom() + "</a> </li>");
		}
	%>
</ul>

<h2>Tout le personnelle</h2>
<table>
<thead>
	<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Email</th>
	</tr>
</thead>

<tbody>
	<%
		List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
		Departement d = (Departement) request.getAttribute("target");
		for(Personne p : personnes){
			out.print("<tr>");
			out.print("<td>" + p.getId() + "</td>");
			out.print("<td>" + p.getNom() + "</td>");
			out.print("<td>" + p.getPrenom() + "</td>");
			out.print("<td>" + p.getEmail() + "</td>");
			out.print("<td> <a href=\"http://localhost:8080/Test_JPA/Departement?add=" + p.getId() + "&id=" + (d != null ? d.getId() : null) + "\"/>Ajouter</td>");
			out.print("</tr>");
		}
	%>
</tbody>
</table>


<%
	if(d != null){
		out.print("<h3>Membres du departement " + d.getNom() + "</h3>");
		for(Personne p : d.getEmployes()){
			out.print("<p>" + p.getNom() + "</p>");
		}
	}
	
%>



</body>
</html>