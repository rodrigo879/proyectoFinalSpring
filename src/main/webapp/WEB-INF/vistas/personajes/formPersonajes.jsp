<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-peliculas').select2();
			$('#form-personaje').validate();
		});
	</script>

	<h1>Formulario de personajes</h1>

	<form:form method="post" enctype="multipart/form-data" action="/personajes/guardar" modelAttribute="personajeForm" id="form-personaje">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control" value="${id}"/>
		</div>

		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>
		
		<div class="form-group">
			<label>Imagen</label>
			<form:input path="foto" cssClass="form-control" type="file"/>
			<form:errors path="foto" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Edad</label>
			<form:input path="edad" cssClass="form-control required number" />
			<form:errors path="edad" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Peso</label>
			<form:input path="peso" cssClass="form-control required number" />
			<form:errors path="peso" cssClass="error"/>
		</div>
		
		<div class="form-group">
			<label>Historia</label>
			<form:input path="historia" cssClass="form-control required" />
			<form:errors path="historia" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Pelicula</label>
			<form:select path="idPelicula" items="${peliculas}" itemLabel="titulo" itemValue="id" cssClass="form-control" id="select-peliculas" />
		</div>


		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
