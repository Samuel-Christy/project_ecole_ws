<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Bibliotheque</title>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<h2>Listes des Livres</h2>

<table>
	<tr>
    <th>Titre</th>
    <th>Année</th>
    <th>Nom_Auteur</th>
     <th>Prenom_Auteur</th>
     <th>Editeur</th>
  </tr>
	<c:forEach var="livres" items="${livres}">
		<tr>
			<td><c:out value="${livres.titre}" /></td>
			<td><c:out value="${livres.annee}" /></td>
			<td><c:out value="${livres.nom_auteur}" /></td>
			<td><c:out value="${livres.prenom_auteur}" /></td>
			<td><c:out value="${livres.editeur}" /></td>
		</tr>
		<input type="submit" value="Reserver"/>
	</c:forEach>
</table>
</body>
</html>
