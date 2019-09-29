<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoa Formulário</title>
</head>
<body>
<spring:url value="/pessoa/save" var="saveURL"></spring:url>
<form:form modelAttribute="pessoaForm" method="POST" action="${saveURL }">
<form:hidden path="id"/>
<table>
<tr>
<td>Nome: </td>
<td>
<form:input path="nome"/>
</td>
</tr>
<tr>
<td>idade: </td>
<td>
<form:input path="idade"/>
</td>
</tr>
<tr>
<td></td>
<td><button type="submit">Adicionar</button></td>
</tr>
</table>
</form:form>

</body>
</html>