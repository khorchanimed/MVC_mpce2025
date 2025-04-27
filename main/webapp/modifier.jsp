<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ page import="model.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier</title>
</head>
<body>


<% 

Article article = (Article)request.getAttribute("article") ; 

%>

<div align="center" style="margin-top: 150px">
		<h2>Modifier Article</h2>

		<form action="articles" method="post">

			<table>
			<tr>
					<td>Id :</td>
					<td><input type="text" name="id" readonly="readonly"  value="<%= article.getId() %>" /></td>
				</tr>
				<tr>
					<td>Nom Article :</td>
					<td><input type="text" name="nom" value="<%= article.getNom() %>"/></td>
				</tr>
				<tr>
					<td>Prix :</td>
					<td><input type="text" name="prix"  value="<%= article.getPrix() %>"/></td>
				</tr>
				<tr>
					<td><input type="hidden" name ="action" value="modifier" >   </td>
					<td><input type="submit" value="Modifier" /></td>
				</tr>
			</table>

		</form>

		
	</div>
</body>
</html>