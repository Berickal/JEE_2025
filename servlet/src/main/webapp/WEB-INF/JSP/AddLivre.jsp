<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Ajouter un livre</h2>
	<%@ include file="/WEB-INF/JSP/Components/menu.jsp" %>
	
	<form method="POST" action="/TestServlet/SecondServlet">
		<label for="titre">Titre</label>
		<input type="text" id="titre" name="titre" />
		</br>
		
		<label for="auteru">Auteur</label>
		<input type="text" id="auteur" name="auteur" />
		</br>
		
		
		<label for="prix">Prix</label>
		<input type="number" id="prix" name="prix" />
		</br>
		
		<input type="submit" />
		
	</form>

</body>
</html>