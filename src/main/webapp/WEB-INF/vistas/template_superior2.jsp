<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Disney</title>
	
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootbox.all.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/messages_es_AR.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/select2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/fontawesome.js"/>"></script>
	
	<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/select2.min.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/general.css"/>" rel="stylesheet" >
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-autocomplete-peliculas').select2({ 
				width: '300px',
				placeholder: 'Buscador peliculas',
				minimumInputLength: 3,
				ajax: {
				    url: '/api/peliculas/buscar',
				    data: function (params) {
				        var query = {
				          titulo: params.term
				        };
				        return query;
				    },
				    processResults: function (data) {
				        var nuevosDatos = [];
				    	
				        for(var pelicula of data) {
				        	nuevosDatos.push({ id: pelicula.id, text: pelicula.titulo});
				        }
				        
				    	return {
				          results: nuevosDatos
				        };
				    },
				    dataType: 'json'
				}
			}).on('select2:select', function(event) {
				window.location = '/peliculas/' + event.params.data.id;
			});
			$('#form-pelicula').validate();
		});
	</script>
</head>
<body>

	<header>
	  <!-- Fixed navbar -->
	  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	    <a class="navbar-brand" href="<c:url value="/"/>">
		    <div style="width: 75px">
		    	<img style="width:100%" src="/image/imagenLogo.png">
		    </div>
	    </a>
	    <div class="collapse navbar-collapse" id="navbarCollapse">
		      <ul class="navbar-nav mr-auto">
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/peliculas"/>">Peliculas</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/personajes"/>">Personajes</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/generos"/>">Generos</a>
		        </li>
		      </ul>
		      
		      <form method="post" class="form-inline mt-2 mt-md-0" action="/" id="form-pelicula">
		      	<select id="select-autocomplete-peliculas"></select>
		      </form>
	    </div>
	  </nav>
	</header>


	<div class="container">
	<!-- INICIO CONTENIDO -->