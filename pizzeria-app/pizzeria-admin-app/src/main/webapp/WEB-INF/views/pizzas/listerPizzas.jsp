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
<script src="<c:url value='/js/jquery-1.12.4.min.js'></c:url>"></script>
<title>Lister les Pizzas</title>
</head>
<body>
	<h1>Gestion des pizzas</h1>

	<ol class="breadcrumb">
		<li><a href="../login">Login</a></li>
		<li><a href="#">Pizzas</a></li>
		<li class="active">Liste</li>
	</ol>

	<div>
		<p>
			Identifié en tant que <span class="label label-info">${email}</span>
		</p>
		<a href="<%=request.getContextPath()%>/logout"
			class="btn btn-danger btn-xs" role="button"><span
			class="glyphicon glyphicon-off" aria-hidden="true"></span> Déconnexion</a>

	</div>


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
								<a href="<%=request.getContextPath()%>/pizzas/new"
									class="btn btn-success" role="button"><span
									class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									Ajouter</a>
							</div></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="pizza" items="${pizzas}">
						<tr>
							<td>${pizza.code}</td>
							<td>${pizza.nom}</td>
							<td>${pizza.prix}€</td>
							<td>${pizza.categorie}</td>

							<td>
								<div class="col-md-2">

									<img src="<%=request.getContextPath()%>/img/${pizza.code}.jpg"
										height=100 width=150>
								</div>
							</td>

							<td>
								<div>
									<a
										href="<%=request.getContextPath()%>/pizzas/edit?code=${pizza.code}"
										class="btn btn-warning" role="button"><span
										class="glyphicon glyphicon-edit" aria-hidden="true"></span> Modifier</a>
								</div>
								<hr>
								<div>
									<a
										href="<%=request.getContextPath()%>/pizzas/delete?code=${pizza.code}"
										class="btn btn-danger" role="button"><span
										class="glyphicon glyphicon-remove" aria-hidden="true"></span> Supprimer</a>
								</div>
							</td>


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