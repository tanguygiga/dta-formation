<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
	<a href="list">Liste des pizzas</a> /
	<a href="index.html">Retour à l'accueil</a>
	<hr>

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Ajouter la nouvelle pizza</legend>

						<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Code</label>
				<div class="col-md-4">
					<input id="textinput" name="code" type="text"
						placeholder="code" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Nom</label>
				<div class="col-md-4">
					<input id="textinput" name="nom" type="text"
						placeholder="nom" class="form-control input-md"
						required="">
				</div>
			</div>

			<!-- Appended Input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="appendedtext">Prix</label>
				<div class="col-md-4">
					<div class="input-group">
						<input id="appendedtext" name="prix" class="form-control"
							placeholder="prix" type="text" required="">
						<span class="input-group-addon">€</span>
					</div>
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="categorie">Catégorie</label>
				<div class="col-md-4">
					<select id="selectbasic" name="categorie" class="form-control">
						<option value="VIANDE">VIANDE</option>
						<option value="POISSON">POISSON</option>
						<option value="VEGETARIEN">VEGETARIEN</option>
					</select>
				</div>
			</div>


			
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<input type="submit" id="singlebutton" name="singlebutton"
						class="btn btn-success" value="Ajouter">
				</div>
			</div>

		</fieldset>
	</form>


</body>
</html>