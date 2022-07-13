package edu.curso.java.spring.proyectospring.service;

public class PeliculaException extends Exception {
	
	public PeliculaException() {
		super();
	}

	public PeliculaException(String mensaje) {
		super(mensaje);
	}

	public PeliculaException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
