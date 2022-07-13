<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de Peliculas <a style="color:black" href="/nuevo" class="btn btn-warning">Nuevo</a></h1>

<script type="text/javascript">
	$(document).ready(function() {
		$('.btn-borrar').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Borrar la pelicula?", function(result){ 
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
			<th>Titulo</th>
			<th>Fecha de Creacion</th>
			<th>Calificacion</th>
			<th>Genero</th>
			<th style="width:230px"></th>
		</tr>
	</thead>
	<c:forEach items="${peliculas}" var="p">
		<tr>
			<td style="vertical-align:middle">${p.titulo}</td>
			<fmt:parseDate value="${p.fechaCreacion}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
			<td style="vertical-align:middle"><fmt:formatDate type="date" value="${parsedDate}" pattern="dd-MM-yyyy" /></td>
			<td style="vertical-align:middle">${p.calificacion}</td>
			<td style="vertical-align:middle">${p.genero.nombre}</td>
			<td style="width:230px">
				<a href="/peliculas/${p.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/peliculas/${p.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/${p.id}/borrar" class="btn btn-danger btn-borrar">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
