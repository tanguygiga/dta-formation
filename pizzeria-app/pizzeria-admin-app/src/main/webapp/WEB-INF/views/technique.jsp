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
<title>Technique</title>
</head>
<body>
	<h1>Behind the scene</h1>

	<ol class="breadcrumb">
		<li class="active"><a href="../login">Technique</a></li>
	</ol>

	<div>
		<p>
			Identifié en tant que <span class="label label-info">${email}</span>
		</p>
		<a href="<%=request.getContextPath()%>/logout"
			class="btn btn-danger btn-xs" role="button"><span
			class="glyphicon glyphicon-off" aria-hidden="true"></span>Déconnexion</a>

	</div>


	<div class="panel panel-default row">
		<!-- Default panel contents -->
		<div class="panel-heading col-md-8 col-md-offset-2">
			<h3>logs</h3>
		</div>

		<!-- Table -->
		<div class="col-md-8 col-md-offset-2">

			<table class="table">

				<thead>
					<tr>
						<th align="left">id</th>
						<th align="left">log</th>
						<th align="left">/</th>


					</tr>
				</thead>
				<tbody>

					<c:forEach varStatus="test" var="log" items="${logs}">

						<tr>
							<td>${test.index}</td>
							<td>${log}</td>
							<td>${log.path }</td>

						</tr>
					</c:forEach>

				</tbody>

			</table>

		</div>
	</div>

	<hr>
</body>
</html>