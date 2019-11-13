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
<h1>Liste des Départements</h1>
<table>
<th>
<td>Id</td>
<td>Nom</td>
<td></td>
<td></td>
</th>

<c:forEach items="${deps}" var="d">
<tr>
<td> ${d.numero}</td>
<td> ${d.nom}</td>
<td><a href='projets/${d.numero}'>Liste des projets</a></td>
<td><a href='employes/dept/${d.numero}'>Liste des employes</a></td>
</tr>
</c:forEach>
</table>
<a href='ajoutProjet'>Ajouter un projet</a>

</body>
</html>