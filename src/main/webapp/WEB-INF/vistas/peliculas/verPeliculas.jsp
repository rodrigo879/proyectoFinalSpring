<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Pelicula: ${peliculas.titulo}</h5>
  <div class="card-body">
  	<fmt:parseDate value="${peliculas.fechaCreacion}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
  	<p class="card-text">Fecha de Creacion: <fmt:formatDate type="date" value="${parsedDate}" pattern="dd-MM-yyyy" /> </p>
    <p class="card-text">Calificacion: <fmt:formatNumber type="number" value="${peliculas.calificacion}" /> </p>
    <p class="card-text">Genero: ${peliculas.genero.nombre}</p>    
 	<p class="card-text">Personajes:</p>	
 	<c:forEach items="${personajes}" var="p">
		<ul>
			<li>${p.nombre}</td>
		</ul>
	</c:forEach>
  </div>
</div>


<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
