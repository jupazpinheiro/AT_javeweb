<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicare!!!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de consultas</h2>
	  <form action="/consulta/incluir" method="post">

		<div class="form-group">
		  <c:if test="${not empty medicos}">
		  	  <label>Medico:</label>
			  <select class="form-control" name="medico.id">
				<c:forEach var="m" items="${medicos}">
					<option value="${m.id}">${m.nome}</option>
				</c:forEach>
			  </select>
		  </c:if>
		  <c:if test="${empty medicos}">
		  	  <c:set var="botao" value="disabled"/>
		  	  <label>Ainda não existem médicos cadastrados</label>
		  </c:if>
		</div>	

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input value="Primeira consulta" type="text" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>	    
		
		<div class="form-group">			
		<c:if test="${not empty exames}">
			<label>Exames:</label>
			<c:forEach var="e" items="${exames}">
			  	<div class="form-check">
					<label class="form-check-label">
					<input name="examesId" type="checkbox" checked="checked" value="${e.id}"> ${e.descricao}
					</label>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${empty exames}">
		    <c:set var="botao" value="disabled"/>
			<label>Ainda não há exames cadastrados!!!</label>
		</c:if>
		</div>	    

	    <button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>