<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/app">Medicare</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Index</a></li>
      <c:if test="${not empty user}">
      	  <li><a href="/medico/lista">Medico</a></li>
      	  <li><a href="/usuario/lista">Usuario</a></li>
      	  <li><a href="/clinico/lista">Clinico</a></li>
      	  <li><a href="/laboratorial/lista">Laboratorial</a></li>
      	  <li><a href="/exame/lista">Exame</a></li>
      	  <li><a href="/consulta/lista">Consulta</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Cadastrar</a></li>
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Logar</a></li>
      </c:if>
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Sair, ${user.nome}!!!</a></li>
      </c:if>
    </ul>
  </div>
</nav>