package VideoStore;

import java.time.LocalDate;

public class Ticket {
	
	private String nombre; 
	private String Direcion;
	private LocalDate fechaDeAlquiler;
	private LocalDate fechaDevolucion;
	private Pelicula pelicula;
	private String dni;
	private int numeroTicket;
	private boolean devolucion;
	
	static int cantidadTicket=0;
	
	public Ticket(String nombre, String direcion, LocalDate fechaDeAlquiler, Pelicula pelicula, String dni) {
		this.nombre = nombre;
		Direcion = direcion;
		this.fechaDeAlquiler = fechaDeAlquiler;
		fechaDevolucion = fechaDeAlquiler.plusDays(10);
		this.pelicula = pelicula;
		this.dni=dni;
		cantidadTicket++;
		devolucion=false;
	}
	
	public Ticket(Cliente cliente, LocalDate fechaDeAlquiler, Pelicula pelicula) {
		nombre = cliente.getName();
		Direcion = cliente.getDireccion();
		this.fechaDeAlquiler = fechaDeAlquiler;
		fechaDevolucion = fechaDeAlquiler.plusDays(10);
		this.pelicula = pelicula;
		dni=cliente.getDni();
		cantidadTicket++;
		devolucion=false;
	}
	
	public boolean isDevolucion() {
		return devolucion;
	}

	public void setDevolucion(boolean devolucion) {
		this.devolucion = devolucion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirecion() {
		return Direcion;
	}

	public void setDirecion(String direcion) {
		Direcion = direcion;
	}

	public LocalDate getFechaDeAlquiler() {
		return fechaDeAlquiler;
	}

	public void setFechaDeAlquiler(LocalDate fechaDeAlquiler) {
		this.fechaDeAlquiler = fechaDeAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean rta=false;
		if(obj!=null) {
			if(obj instanceof Ticket) {
				Ticket aux= (Ticket)obj;
				if(aux.getNumeroTicket()==numeroTicket) {
					rta=true;
				}
			}
		}
		return rta;
	}

	@Override
	public String toString() {
		return "Ticket [nombre=" + nombre + ", Direcion=" + Direcion + ", fechaDeAlquiler=" + fechaDeAlquiler
				+ ", fechaDevolucion=" + fechaDevolucion + ", pelicula=" + pelicula + ", dni=" + dni + ", numeroTicket="
				+ numeroTicket + ", devolucion=" + devolucion + "]";
	}
	
}