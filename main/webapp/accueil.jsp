<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.User , model.Article"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

	<%
	ArrayList<Article> articles =null ; 
	
	if (session.getAttribute("user") != null)

	{
		 articles =(ArrayList<Article>) request.getAttribute("articles") ; 

		User u = (User) session.getAttribute("user");
	%>
	<h3 style="color: white; text-align: right; background-color: green;">
		Bonjour
		<%=u.getNom() + " " + u.getPrenom()%>
		| <a href="login" style="color: orange; padding: 5px">Fermer
			Session</a>
	</h3>

	<%
	} else
	request.getRequestDispatcher("index.jsp").forward(request, response);
	%>

<div align="center" style="margin-top: 150px" >
<a href="ajouter.jsp"> Ajouter Article </a>
	  <% if ( articles.size()>0) {
		  %>
	
	  <table width="50%">
	  <tr>
	  <th>Id</th>
	   <th>Nom</th>
	    <th>Prix</th>
	     <th>Actions</th>
	  </tr>
	  
	  <% for (Article art : articles) {
		  %>
	  
	   <tr>
	  <th><%= art.getId() %></th>
	   <th><%= art.getNom() %></th>
	    <th><%= art.getPrix() %></th>
	     <th><a href="articles?id=<%= art.getId() %>&action=supp" onClick="return confirm('Supprimer <%= art.getNom() %> ? ')"> Supprimer </a> | <a href="articles?id=<%= art.getId() %>&action=modifier">  Modifier</a> </th>
	  </tr>
	  <% } %>
	  
	  </table>
	    <% }
	    else
	     { out.println ("<h2>Aucun Article</h2>") ; }
		  %>
	  
   
</div>

</body>
</html>