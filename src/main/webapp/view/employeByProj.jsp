<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.Vector" %>
<%@ page import="tp1.model.*" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des Employés</h1>
<h2>Département : ${projet.titre}  </h2>
<table>
<th>
<td>Id</td>
<td>Nom</td>
<td>Fonction</td>
<td></td>
<td></td>
</th>

<c:forEach items="${employesProj}" var="employe">
<tr>
<td> ${employe.numero}</td>
<td> ${employe.nom}</td>
<td> ${employe.fonction}</td>
</tr>
</c:forEach>
</table>
<a href='../../ajoutEmploye'>Ajouter un employe</a>

</body>
</html>