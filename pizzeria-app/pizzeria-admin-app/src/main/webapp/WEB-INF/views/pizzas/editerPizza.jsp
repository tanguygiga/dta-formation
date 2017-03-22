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
<title>Editer une pizza</title>
</head>
<body>

<h1>Gestion des pizzas</h1>
	<a href="pizzas/list">Liste des pizzas</a> /
	<a href="index.html">Retour à l'accueil</a>
	<hr>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Editer la pizza</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Code</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="code" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Nom</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="nom" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Appended Input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="appendedtext">Prix</label>
  <div class="col-md-4">
    <div class="input-group">
      <input id="appendedtext" name="appendedtext" class="form-control" placeholder="prix" type="text" required="">
      <span class="input-group-addon">€</span>
    </div>
    
  </div>
</div>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Catégorie</label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="VIANDE">VIANDE</option>
      <option value="POISSON">POISSON</option>
      <option value="VEGETARIEN">VEGETARIEN</option>
    </select>
  </div>
</div>


<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="filebutton">Image</label>
  <div class="col-md-4">
    <input id="filebutton" name="filebutton" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-warning">Editer</button>
  </div>
</div>

</fieldset>
</form>


</body>
</html>