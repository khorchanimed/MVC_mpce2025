<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="margin-top: 150px">
		<h2>Ajouter Article</h2>

		<form action="articles" method="post">

			<table>
				<tr>
					<td>Nom Article :</td>
					<td><input type="text" name="nom" /></td>
				</tr>
				<tr>
					<td>Prix :</td>
					<td><input type="text" name="prix" /></td>
				</tr>
				<tr>
					<td><input type="hidden" name ="action" value="ajouter" >   </td>
					<td><input type="submit" value="Ajouter" /></td>
				</tr>
			</table>

		</form>

		
	</div>
</body>
</html>