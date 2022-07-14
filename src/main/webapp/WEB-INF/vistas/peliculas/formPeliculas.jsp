<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-generos').select2();
			$('#form-peliculas').validate();
		});
	</script>

	<h1>Formulario de peliculas</h1>

	<form:form method="post" action="/personajes/guardar" modelAttribute="peliculaForm" id="form-peliculas">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control" value="${id}"/>
		</div>


		<div class="form-group">
			<label>Titulo</label>
			<form:input path="titulo" cssClass="form-control required" />
			<form:errors path="titulo" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Fecha de Creacion</label>
			<form:input path="fechaCreacion" cssClass="form-control" value="${fechaCreacion}" type="date"/>
			<form:errors path="fechaCreacion" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Calificacion</label>
			<form:input path="calificacion" cssClass="form-control required number" />
			<form:errors path="calificacion" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Genero</label>
			<form:select path="idGenero" items="${generos}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-generos" />
		</div>


		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
