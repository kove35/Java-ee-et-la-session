 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jeu de hasard</title>
</head>
<body>
	<form method="post" action="controleur.php"  >
	<label for="nombreDevinez">Dévinez ce nombre </label>
	<input type="text" name="nombreDevinez" value="${model.nombre}"/>
	<input type="submit" name="action" value="jouer" />
	<input type="submit" name="action" value="Rejouer" />
	</form>
	<table>
		<c:forEach items="${model.historique}" var="p">
			<tr>
				<td>${p}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>