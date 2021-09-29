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

		<form action="/clinico" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
			  <strong>Sucesso!</strong> ${msg}
			</div>
		</c:if>

		<c:if test="${not empty clinicos}">
			<h4>Quantidade pedidos de exames: ${clinicos.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Descrição</th>
		        <th>Valor</th>
		        <th>Urgente</th>
		        <th>Plano</th>
		        <th>Tipo de acomodação</th>
		        <th>Urgente</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="c" items="${clinicos}">
			      <tr>
			        <td>${c.id}</td>
			        <td>${c.descricao}</td>
			        <td>${c.valor}</td>
			        <td>${c.urgente}</td>
			        <td>${c.plano}</td>
			        <td>${c.tipoAcomoda}</td>
			        <td>${c.urgente}</td>
			        <td><a href="/clinico/${c.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty clinicos}">
			<h4>Não existem exames clínicos cadastrados!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>