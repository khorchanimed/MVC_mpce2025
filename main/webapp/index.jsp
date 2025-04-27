<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>
<body>

	<div align="center" style="margin-top: 150px">
		<h2>Authentification</h2>

		<form action="login" method="post">

			<table>
				<tr>
					<td>Login :</td>
					<td><input type="text" name="login" /></td>
				</tr>
				<tr>
					<td>Mot de passe :</td>
					<td><input type="text" name="pwd" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="se connecter" /></td>
				</tr>
			</table>

		</form>

		<%
		if (request.getAttribute("erreur") != null)

		{
		%>
		 <h3 style="color: white ; background-color: red;">Login ou Mot de passe incorrect</h3>

		<%
		}
		%>
	</div>
</body>
</html>