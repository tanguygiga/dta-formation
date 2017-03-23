<%@page import="fr.pizzeria.model.Pizza"%>

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
<title>Ajouter une nouvelle pizza</title>
</head>
<body>

	<h1>Gestion des pizzas</h1>
	<a href="pizzas/list">Liste des pizzas</a> /
	<a href="index.html">Retour à l'accueil</a>
	<hr>
	<div class="col-md-8 col-md-offset-2">
		<form class="form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Login</legend>

				<c:if test="${!connected}">
					<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> Non connecté !</div>
				</c:if>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">email</label>
					<div class="col-md-4">
						<input id="" name="email" type="text" placeholder="email@exemple.com"
							class="form-control input-md">

					</div>
				</div>


				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Mot de passe</label>
					<div class="col-md-4">
						<input id="" name="password" type="password" placeholder=""
							class="form-control input-md">

					</div>
				</div>


				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-8">
						<button id="" name="" class="btn btn-success">Login</button>
						<button id="" name="" class="btn btn-warning">Cancel</button>

					</div>
				</div>

			</fieldset>
		</form>
	</div>

</body>
</html>