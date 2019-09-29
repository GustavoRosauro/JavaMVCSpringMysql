<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoa Page</title>
</head>
<body>
<h1>Lista de Pessoas</h1>
<spring:url value="/pessoa/add" var="addUrl"></spring:url>
<a href="${addUrl }">Novo Usuário</a>
<table width="100%" border="1">
<tr>
<th>ID</th>
<th>Nome</th>
<th>Idade</th>
</tr>
<c:forEach items="${listaPessoa }" var="pessoa">
<tr>
<td>${pessoa.id}</td>
<td>${pessoa.nome}</td>
<td>${pessoa.idade}</td>
<td>
<spring:url value="/pessoa/update/${pessoa.id }" var="updateURL"/>
<a href="${updateURL }">Editar</a>
</td>
<td>
<spring:url value="/pessoa/delete/${pessoa.id }" var="deleteURL"/>
<a href="${deleteURL }">Remover</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>