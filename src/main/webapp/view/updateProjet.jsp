<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
</head>
<body>
<h1>Modifier un Projet</h1>
<form:form  action="${cxt}/updateProject" modelAttribute="projet" method="POST" >
    <table>
    <form:input type="hidden" path="numero" />
        <tr>
            <td>titre</td>
            <td><form:input type="text" path="titre" /></td>
          </tr>
          <tr>
            <td>Etat:</td>
            <td><form:select path="etat" >
            <form:option value="1" label="Non Lancé" />
            <form:option value="2" label="Lancé" />
            </form:select>
          </tr>
               <tr>
            <td>Departement:</td>
            <td>
            <form:select path="departement.numero" items="${departements}"
            itemValue="numero" itemLabel="nom" />
            
       
            </td>
          </tr>

            <td colspan="2">
                  <input class="btn btn-warning" type="submit" value="enregistrer" />
            </td>
          </tr>
    </table>
</form:form>
  </div>
</body>
</html>