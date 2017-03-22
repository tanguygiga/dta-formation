<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Lister les Pizzas</title>
</head>
<body>
	<h1>Gestion des pizzas</h1>
	<a href="AjouterPizzas.html">Ajout</a> /
	<a href="index.html">Retour à l'accueil</a>


	<div class="panel panel-default row">
		<!-- Default panel contents -->
		<div class="panel-heading col-md-8 col-md-offset-2">
			<h3>Liste des pizzas</h3>
		</div>

		<!-- Table -->
		<div class="col-md-8 col-md-offset-2">

			<table class="table">

				<thead>
					<tr>
						<th align="left">Code</th>
						<th align="left">Nom</th>
						<th align="left">Prix</th>
						<th align="left">Catégorie</th>
						<th align="Right">Image</th>
						<th align="Right"><div>
								<a href="#" class="btn btn-success" role="button"><span
									class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
							</div></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="pizza" items="${pizzas}">
						<tr>
							<td>${pizza.code}</td>
							<td>${pizza.nom}</td>
							<td>${pizza.prix}</td>
							<td>${pizza.categorie}</td>
										
						<td>
							<div class="col-md-2">

								<img
									src="<%=request.getContextPath()%>/img/${pizza.code}.jpg"
									height=100 width=150>
							</div>
						</td>

						<td>
							<div>
								<a
									href="<%=request.getContextPath()%>/pizzas/edit?code=${pizza.code}"
									class="btn btn-warning" role="button"><span
									class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
							</div>
							<hr>
							<div>
								<a href="#" class="btn btn-danger" role="button"><span
									class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							</div>


						</td>

					</tr>
					</c:forEach>

				</tbody>

			</table>

		</div>
	</div>

	<hr>
</body>
</html>