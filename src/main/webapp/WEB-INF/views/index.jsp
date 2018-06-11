<%@ page pageEncoding="UTF-8"%>
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
  <tr>
    <td>Un tramway nommé désir</td>
    <td>1947</td>
    <td>Willimas</td>
    <td>Tenessee</td>
    <td>livre de poche</td>
  </tr>
  <tr>
    <td>Le vieux qui lisait des romans d'amour</td>
    <td>1992</td>
    <td>Spulveda</td>
    <td>Luis</td>
    <td>livre de poche</td>
  </tr>
     <tr>
    <td>Guerre et paix</td>
    <td>1869</td>
    <td>Tolstoy</td>
    <td>Léon</td>
    <td>livre de poche</td>
  </tr>
  <input type="submit" value="Reserver"/>
</table>
</body>
</html>
