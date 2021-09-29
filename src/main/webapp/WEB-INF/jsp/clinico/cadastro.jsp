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
	  <h2>Cadastro de Exames clínicos</h2>
	  <form action="/clinico/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Motivo do exame" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="10" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>
		
	    <div class="form-group">
	      <label>Plano:</label>
	      <input type="text" value="Unimed" class="form-control" placeholder="Entre com a plano" name="plano">
	    </div>

	    <div class="form-group">
	      <label>Tipo de acomodação:</label>
	      <input type="text" value="5" class="form-control" placeholder="Entre com o tipo de acomodação" name="tipoAcomoda">
	    </div>

	    <div class="form-group">
	      <label>Características:</label>
			<label class="checkbox-inline"><input type="checkbox" name="urgente" checked>Urgente</label>
			<label class="checkbox-inline"><input type="checkbox" name="cobertura">Cobertura</label>
	    </div>

	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>