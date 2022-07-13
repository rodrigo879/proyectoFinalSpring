<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de Personajes <a style="color:black" href="/personajes/nuevo" class="btn btn-warning">Nuevo</a></h1>

<script type="text/javascript">
	$(document).ready(function() {
		$('.btn-borrar').on('click', function(event) {
			event.preventDefault();
			var hrefOriginal = $(this).attr('href');
			bootbox.confirm("Borrar el Personaje?", function(result){ 
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
			<th>Imagen</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Peso</th>
			<th>Historia</th>
			<th style="width:230px"></th>
		</tr>
	</thead>
	<c:forEach items="${personajes}" var="p">
		<tr>
		
			<td>
				<div style="width:50px">
					<img style="width:100%" src="/image/${p.imagen}" alt="${p.imagen}"> 
				</div>
			</td>
			<td style="text-align:center; vertical-align:middle">${p.nombre}</td>
			<td style="text-align:center; vertical-align:middle">${p.edad}</td>
			<td style="text-align:center; vertical-align:middle">${p.peso}</td>
			<td style="text-align:left; vertical-align:middle">${p.historia}</td>
			
			<td style="width:230px">
				<a href="/personajes/${p.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/personajes/${p.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/personajes/${p.id}/borrar" class="btn btn-danger btn-borrar">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
