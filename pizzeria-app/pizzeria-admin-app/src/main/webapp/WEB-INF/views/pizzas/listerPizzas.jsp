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
<h1>Gestion des pizzas</h1>
       <a href="AjouterPizzas.html">Ajout</a> / <a href="index.html">Retour à l'accueil</a>
       <h2>Liste des pizzas</h2>
       <table cellspacing="10">
           <thead>
               <tr>
                   <th align="left">Code</th>
                   <th align="left">Nom</th>
                   <th align="left">Prix</th>
                   <th align="left">Catégorie</th>
                   <th align="left">Image</th>
               </tr>
           </thead>
           <tbody>
               <%
                List<Pizza> pizzas = (List<Pizza>) request.getAttribute("pizzas");
                for(Pizza pizza : pizzas){
                %>
                <tr>
                    <td><%=pizza.getCode()%></td>
                    <td><%=pizza.getNom()%></td>
                    <td><%=pizza.getPrix()%></td>
                    <td><%=pizza.getCategorie()%></td>
                    <td><img src="<%=pizza.getUrl()%>" width="100px" height="100px;"></td>
                </tr>
                <%
                }
                %>
           </tbody>
       </table>
</body>
</html>