<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@page import="" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lister les Pizzas</title>
</head>
<body>

<h1> Page Lister les Pizzas</h1>

<%

List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listPizzas");

%>

</body>
</html>