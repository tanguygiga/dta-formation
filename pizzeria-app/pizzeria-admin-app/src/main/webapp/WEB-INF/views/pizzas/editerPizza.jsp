<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Editer une pizza</title>
</head>

<body>
	<h1>Gestion des pizzas</h1>
	<a href="list">Liste des pizzas</a> /
	<a href="index.html">Retour à l'accueil</a>
	<hr>

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Editer la pizza</legend>

			<%
				Pizza pizza = (Pizza) request.getAttribute("pizza");
			%>
			<input type='hidden' name='oldCode' value='${pizza.code}'>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="InputCode">Code</label>
				<div class="col-md-4">
					<input class="form-control input-md" name="newCode" type="text"
						value='${pizza.code}' required>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="InputNom">Nom</label>
				<div class="col-md-4">
					<input class="form-control input-md" name="nom" type="text"
						value='${pizza.nom}' required>
				</div>

			</div>

			<!-- Appended Input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="InputPrix">Prix</label>
				<div class="col-md-4">
					<div class="input-group">
						<input name="prix" class="form-control" type="text"
							value='${pizza.prix}' required> <span
							class="input-group-addon">€</span>
					</div>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="selectbasic">Catégorie</label>
				<div class="col-md-4">
					<select id="selectbasic" name="categorie" class="form-control">
						<c:set var="categorie" scope="request" value="${pizza.categorie}"></c:set>
						<option ${categorie == 'VIANDE' ? 'selected' : ''} value="VIANDE">VIANDE</option>
						<option ${categorie == 'POISSON' ? 'selected' : ''}
							value="POISSON">POISSON</option>
						<option ${categorie == 'VEGETARIEN' ? 'selected' : ''}
							value="VEGETARIEN">VEGETARIEN</option>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-warning">
						<span class="glyphicon glyphicon-edit"></span> Éditer
					</button>
				</div>
			</div>

			<div class="col-md-4 col-md-offset-4">
				<img src="<%=request.getContextPath()%>/img/${pizza.code}.jpg"
					height=100>
			</div>

		</fieldset>
	</form>


</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>