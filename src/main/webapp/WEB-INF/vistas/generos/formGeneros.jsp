<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#form-generos').validate();
		});
	</script>

	<h1>Formulario de genero</h1>

	<form:form method="post" action="/generos/guardar" modelAttribute="generoForm" id="form-generos">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control" value="${id}"/>
		</div>


		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>

		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
