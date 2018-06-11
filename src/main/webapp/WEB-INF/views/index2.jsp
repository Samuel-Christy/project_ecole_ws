<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Bibliotheque</title>
<head>
<link rel="stylesheet" href="/assets/vendor/datatables/Bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="/assets/vendor/datatables/Bootstrap-3.3.7/css/bootstrap-theme.css">

<script src="/assets/vendor/datatables/jQuery-3.2.1/jquery-3.2.1.min.js"></script>

<link rel="stylesheet" href="/assets/vendor/datatables/datatables.css">
<script src="/assets/vendor/datatables/datatables.js"></script>
<style>

    div.container {
        width: 80%;
    }

    table{
        width: 100%;
    }
</style>



</head>
<body style="">

<h2>Listes des Livres</h2>




<div class="table-responsive">
<table id="books" class=" table table-hover" >
    <thead>
	<tr><th>Action</th>
    <th>id</th>
    <th>Titre</th>
    <th>Ann�e</th>
    <th>Nom Auteur</th>
     <th>Pr�nom Auteur</th>
     <th>&Eacute;diteur</th>

  </tr>
    </thead>
    <tbody>
	<c:forEach var="livre" items="${livres}">
		<tr><td><a class="btn btn-xs btn-success" href="">R�server</a></td>
            <td><c:out value="${livre.id}"/></td>
			<td><c:out value="${livre.titre}"/></td>
			<td><c:out value="${livre.annee}"/></td>
			<td><c:out value="${livre.nom_auteur}" /></td>
			<td><c:out value="${livre.prenom_auteur}" /></td>
			<td><c:out value="${livre.editeur}" /></td>

		</tr>
		
	</c:forEach>
    </tbody>
</table>
</div>
</body>
<script src="/assets/vendor/datatables/Bootstrap-3.3.7/js/bootstrap.js"></script>

<script>
    $(document).ready(function() {
        $('#books').DataTable( {
            "columnDefs": [
                {
                    "targets": [ 0 ],
                    "sortable" : false, //buttons are not sortable !
                },
            ],
            dom: 'Bfrtip',
            buttons: [
                {
                    extend: 'colvis',
                    text:'Afficher / Masquer colonnes',
                    columns: ':gt(0)',

                }
            ],
            responsive: true,
            stateSave: true,
            "info":     false,
            "language": {
                "sProcessing":     "Traitement en cours...",
                "sSearch":         "Rechercher&nbsp;:",
                "sLengthMenu":     "Afficher _MENU_ &eacute;l&eacute;ments",
                "sInfo":           "Affichage de l'&eacute;l&eacute;ment _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
                "sInfoEmpty":      "Affichage de l'&eacute;l&eacute;ment 0 &agrave; 0 sur 0 &eacute;l&eacute;ment",
                "sInfoFiltered":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
                "sInfoPostFix":    "",
                "sLoadingRecords": "Chargement en cours...",
                "sZeroRecords":    "Aucun &eacute;l&eacute;ment &agrave; afficher",
                "sEmptyTable":     "Aucune donn&eacute;e disponible dans le tableau",
                "oPaginate": {
                    "sFirst":      "Premier",
                    "sPrevious":   "Pr&eacute;c&eacute;dent",
                    "sNext":       "Suivant",
                    "sLast":       "Dernier"
                },
                "oAria": {
                    "sSortAscending":  ": activer pour trier la colonne par ordre croissant",
                    "sSortDescending": ": activer pour trier la colonne par ordre d&eacute;croissant"
                }
            }

        } );
    } );
</script>
</html>
