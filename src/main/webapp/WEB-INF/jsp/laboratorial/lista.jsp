<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicare</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/laboratorial" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
			  <strong>Sucesso!</strong> ${msg}
			</div>
		</c:if>

		<c:if test="${not empty laboratoriais}">
			<h4>Quantidade de exames: ${laboratoriais.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Descrição</th>
		        <th>Valor</th>
		        <th>Urgente</th>
		        <th>Amostra</th>
		        <th>Cobertura</th>
		        <th>Areas</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="l" items="${laboratoriais}">
			      <tr>
			        <td>${l.id}</td>
			        <td>${l.descricao}</td>
			        <td>${l.valor}</td>
			        <td>${l.urgente}</td>
			        <td>${l.amostra}</td>
			        <td>${l.cobertura}</td>
			        <td>${l.area}</td>
			        <td><a href="/laboratorial/${l.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty laboratoriais}">
			<h4>Não existem exames cadastrados!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>