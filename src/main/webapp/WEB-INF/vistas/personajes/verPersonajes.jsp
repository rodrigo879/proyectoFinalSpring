<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Personaje: ${personajes.nombre}</h5>
  <div class="card-body">
  	<div style="width:150px">
		<img style="width:100%" src="/image/${personajes.imagen}" alt="${personajes.imagen}"> 
	</div>
    <p class="card-text">Edad: <fmt:formatNumber type="number" value="${personajes.edad}" /></p>
    <p class="card-text">Peso: <fmt:formatNumber type="number" value="${personajes.peso}" /></p>
    <p class="card-text">Historia:</p>
    <p class="card-text" style="padding-left:50px">${personajes.historia} </p>    

  </div>
</div>


<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
