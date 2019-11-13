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
<h1>Liste des Projets</h1>
<h2>Département : ${departement.nom}  </h2>
<table>
<th>
<td>Id</td>
<td>Titre</td>
<td>employes</td>
<td>action</td>
</th>

<c:forEach items="${projets}" var="projet">
<tr>
<td> ${projet.numero}</td>
<td> ${projet.titre}</td>
<td> ${projet.etat}</td>

<td><a href='../employes/proj/${projet.numero}'>Liste des employees</a></td>
<td><a href='../deleteProjet/${projet.numero}'>supprimer</a></td>
<td><a href='../updateProjet/${projet.numero}'>update</a></td>


</tr>
</c:forEach>
</table>
<a href='../ajoutProjet'>Ajouter un projet</a>

</body>
</html>