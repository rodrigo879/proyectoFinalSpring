<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Formulario de Login</h1>

	<form method="post" action="/validarUser" id="form-peliculas">

		<div class="form-group">
			<label style="width: 100px">Usuario</label>
			<input style="width: 220px" type="text" placeholder="Ingrese su nombre de usuario" name="username">
		</div>

		<div class="form-group">
			<label style="width: 100px">Contraseña</label>
			<input style="width: 220px" type="password" placeholder="Ingrese su contraseña" name="password">
		</div>

		<button type="submit" class="btn btn-secondary">Entrar</button>
	</form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
