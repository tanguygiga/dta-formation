<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<hr>

	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">
			<h3>Liste des pizzas</h3>
		</div>

		<!-- Table -->
		<table class="table">

			<thead>
				<tr>
					<th align="left">Code</th>
					<th align="left">Nom</th>
					<th align="left">Prix</th>
					<th align="left">Catégorie</th>
					<th align="right">Image</th>
					<th align="Center"></th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Pizza> pizzas = (List<Pizza>) request.getAttribute("pizzas");
					for (Pizza pizza : pizzas) {
				%>
				<tr>
					<td><%=pizza.getCode()%></td>
					<td><%=pizza.getNom()%></td>
					<td><%=pizza.getPrix()%> €</td>
					<td><%=pizza.getCategorie()%></td>
					<td>
						<div>
							<img
								src="<%=request.getContextPath()%>/img/<%=pizza.getCode()%>.jpg"
								height=100>
						</div>
					</td>

					<td>
						<div>
							<a href="/pizzas/edit?code=<%=pizza.getCode()%>"
								class="btn btn-default" role="button"><span
								class="glyphicon glyphicon-edit" aria-hidden="true"> </span></a>
						</div>

						<div>
							<a href="/pizzas/edit?code=<%=pizza.getCode()%>"
								class="btn btn-default" role="button"><span
								class="glyphicon glyphicon-remove" aria-hidden="true"> </span></a>
						</div>




					</td>

				</tr>
				<%
					}
				%>
			</tbody>

		</table>
	</div>

	<hr>


</body>
</html>