package VideoStore;

import java.util.ArrayList;

public class Cliente {
	
	private String name;
	private String direccion;
	private String dni;
	private ArrayList<Ticket> peliculasAlquiladas; ///HISTORIAL DE PELICUALAS ALQUILADAS
	
	public Cliente() {
		name= "";
		direccion="";
		dni="";
		peliculasAlquiladas= new ArrayList<>();
	}
	
	public Cliente(Ticket nuevo) {
		name= nuevo.getNombre();
		direccion=nuevo.getDirecion();
		dni=nuevo.getDni();
		peliculasAlquiladas= new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return 0;
	}
	
	public boolean alquilarPelicula(Ticket ingreso) {
		return peliculasAlquiladas.add(ingreso);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean rta=false;
		if(obj!=null) {
			if(obj instanceof Cliente) {
				Cliente aux= (Cliente)obj;
				if(aux.getDni().equals(this.dni) ) {
					rta=true;
				}
			}
		}
		return rta;
	}

	@Override
	public String toString() {
		return "Cliente [name=" + name + ", direccion=" + direccion + ", dni=" + dni + ", peliculasAlquiladas="
				+ peliculasAlquiladas + "]";
	}
	
}