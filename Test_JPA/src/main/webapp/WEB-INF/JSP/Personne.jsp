<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.test.entities.Personne" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Gestion du personnelle</h1>


<h2>Ajouter un personnel</h2>
<form method="POST" action="Personne">

	<input type="hidden" id="id" name="id" value = "${ !empty target ? target.id : -1 }"/>
	
	
	<label>Nom</label>
	<input type="text" id="nom" name="nom" value = "${ !empty target ? target.nom : null }"/>
	<br/>
	
	<label>Prenom</label>
	<input type="text" id="prenom" name="prenom" value = "${ !empty target ? target.prenom : null }"/>
	<br/>
	
	<label>Email</label>
	<input type="text" id="email" name="email" value = "${ !empty target ? target.email : null }"/>
	<br/>
	
	<a href="http://localhost:8080/Test_JPA/Personne">Reset</a>
	<input type="submit" />
</form>

<h2>List du personnelle</h2>

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
		for(Personne p : personnes){
			out.print("<tr>");
			out.print("<td>" + p.getId() + "</td>");
			out.print("<td>" + p.getNom() + "</td>");
			out.print("<td>" + p.getPrenom() + "</td>");
			out.print("<td>" + p.getEmail() + "</td>");
			out.print("<td> <a href=\"http://localhost:8080/Test_JPA/Personne?id=" + p.getId() + "\"/>Modifier</td>");
			out.print("</tr>");
		}
	%>
</tbody>
</table>


</body>
</html>