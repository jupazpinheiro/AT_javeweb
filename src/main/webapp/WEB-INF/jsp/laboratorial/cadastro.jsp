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
	  <h2>Cadastro de exames Laboratoriais</h2>
	  <form action="/laboratorial/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Armazenamento do material" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="100" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>
		
	    <div class="form-group">
	      <label>Amostras:</label>
	      <input type="text" value="4" class="form-control" placeholder="Entre com a quantidade de amostras" name="amostras">
	    </div>

	    <div class="form-group">
	      <label>Laboratórios de destino:</label>
	      <input type="text" value="Microbiologia, Parasitologia e Micologia" class="form-control" placeholder="Entre com os laboratórios de destino" name="areas">
	    </div>

	    <div class="form-group">
	      <label>Características:</label>
			<label class="checkbox-inline"><input type="checkbox" name="urgente">Urgente</label>
			<label class="checkbox-inline"><input type="checkbox" name="cobertura">Cobertura</label>
	    </div>

	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>