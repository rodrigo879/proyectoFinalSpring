<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de generos <a style="color:black" href="/generos/nuevo" class="btn btn-warning">Nuevo</a></h1>

<script type="text/javascript">
	$(document).ready(function() {
		$('.btn-borrar').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Borrar el genero?", function(result){ 
				if(result) {
					window.location = hrefOriginal;
				}
			});
			
		});
	});	
</script>
<table class="table table-striped table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${generos}" var="g">
		<tr>
			<td>${g.id}</td>
			<td>${g.nombre}</td>
			<td>
				<a href="/generos/${g.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/generos/${g.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/generos/${g.id}/borrar" class="btn btn-danger btn-borrar">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
