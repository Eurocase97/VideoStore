package VideoStore;

public class Pelicula {
	
	private String titulo;
	private String genero;
	private String fecha;
	private int duracion;
	private String clasificacion;
	private String descripcion;
	private String pais;
	private int stock;
	
	
	public Pelicula() {
		titulo = "";
		genero = "";
		fecha = "0000-00-00";
		duracion = 00;
		clasificacion = "";
		descripcion = "";
		pais = "";
		stock = 1;
	}
	
	public Pelicula(String titulo, int stock) {
		this.titulo = titulo;
		this.stock = stock;
	}
	
	public Pelicula(String titulo) {
		this.titulo = titulo;
	}
	
	public Pelicula(String titulo, String genero, String fecha, int duracion, String clasificacion,
			String descripcion, String pais, int stock) {
		this.titulo = titulo;
		this.genero = genero;
		this.fecha = fecha;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.descripcion = descripcion;
		this.pais = pais;
		this.stock = stock;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void sumarCantidadStock(int cantidad) {
		stock=stock+cantidad;
	}
	
	public void restarCantidadStock(int cantidad) {
		stock=stock-cantidad;
	}

	@Override
	public String toString() {
		return "Iitulo= " + titulo+ " stock= +"	+ stock;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean rta=false;
		if(obj!=null) {
			if(obj instanceof Pelicula) {
				Pelicula aux= (Pelicula)obj;
				if(aux.getTitulo().equals(this.titulo)) {
					rta=true;
				}
			}
		}
		return rta;
	}	
}