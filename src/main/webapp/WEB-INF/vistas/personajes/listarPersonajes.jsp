<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

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

<script type="text/javascript">
	$(document).ready(function() {
		$('#select-peliculas').select2().on('select2:select', function(event) {
			window.location = '/personajes/pelicula/' + event.params.data.id;
		});
		$('#form-personaje').validate();
	});
</script>
<style>
	#form-personaje {
		display: inline-block;
		width: 30%;
		padding-left: 10px;
	}	
	h1 {
		display: inline
	}
	.top-container {
		display: flex;
		align-items: center;
	}
	.cabecera-tabla {
		width: 50px;
	}
	th {
		text-align: center;
	}
</style>

<div class="top-container">
	<h1>Listado de Personajes <a style="color:black; border-radius: 50%" href="/personajes/nuevo" class="btn btn-success"><i class="fa-solid fa-circle-plus"></i></a></h1>
	
	<form:form method="post" action="/personajes/pelicula" modelAttribute="personajeForm" id="form-personaje">
	 	<form:select path="idPelicula" cssClass="form-control" id="select-peliculas">
	 		<form:option value="">Filtrar Por Pelicula</form:option>
	 		<form:options items="${peliculas}" itemValue="id" itemLabel="titulo"></form:options>
	 	</form:select>
	</form:form>
</div>

<table class="table table-striped table-bordered">
	<thead class="thead-dark">
		<tr>
			<th class="cabecera-tabla">Imagen</th>
			<th class="cabecera-tabla">Nombre</th>
			<th class="cabecera-tabla">Edad</th>
			<th class="cabecera-tabla">Peso</th>
			<th>Historia</th>
			<th style="width: 150px">Pelicula</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${personajes}" var="p">
		<tr>
		
			<td>
				<div style="width:50px">
					<a href="/personajes/${p.id}">
						<img style="width:100%" src="/image/${p.imagen}" alt="${p.imagen}">
					</a> 
				</div>
			</td>
			<td style="text-align:center; vertical-align:middle">${p.nombre}</td>
			<td style="text-align:center; vertical-align:middle">${p.edad}</td>
			<td style="text-align:center; vertical-align:middle">${p.peso}</td>
			<td style="text-align:left; vertical-align:middle">${p.historia}</td>
			<td style="text-align:center; vertical-align:middle">${p.pelicula.titulo}</td>
			
			<td>
				<a href="/personajes/${p.id}/borrar" class="btn btn-danger btn-borrar"><i class="fa-solid fa-trash-can"></i></a>
				
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
