package VideoStore;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class Catalogo {
	
	static final  String nombreArchivoPelicula= "archivoCatalogo.dat";
	
	private HashSet<Pelicula> catalogo;
	
	public Catalogo() {
		catalogo=new HashSet<Pelicula>();
	}
	
	public boolean agregarPelicula(Pelicula nueva) {
		boolean resultado=false;
		if(!catalogo.contains(nueva)) {
			catalogo.add(nueva);
			resultado=true;
		}
		return resultado;
	}
	
	public boolean eliminarPelicula(String nombre) {
		boolean resultado=false;
		Iterator<Pelicula> it= catalogo.iterator();
		while(it.hasNext() && !resultado) {
			Pelicula aux= it.next();
			resultado = aux.getTitulo().equals(nombre);
			if(resultado) {
				catalogo.remove(aux);
			}
		}
		return resultado;
	}
	
	public boolean eliminarPelicula(Pelicula nueva) {
		boolean resultado=false;
		if(nueva!=null) {
			if(catalogo.contains(nueva)) {
				catalogo.remove(nueva);
				resultado=true;
			}
		}
		return resultado;
	}
	
	public String mostrarCatalogo() {
		return catalogo.toString();
	}
	
	public Pelicula getPelicula(String titulo) {
		Pelicula p=null;
		Iterator<Pelicula> it= catalogo.iterator();
		while(it.hasNext() && p==null) {
			Pelicula aux= it.next();
			if(	aux.getTitulo().equals(titulo)) {
				p=aux;
			}
	}
		return p;
	}
	
	public  void guardarCatalogo() {
		DataOutputStream data= null;
		try {
			data = new DataOutputStream(new FileOutputStream(nombreArchivoPelicula));
			Iterator<Pelicula> it= catalogo.iterator();
			while(it.hasNext()) {
				Pelicula aux=(Pelicula) it.next();
				data.writeUTF(aux.getTitulo());
				data.writeInt(aux.getStock());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				data.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void cargarArchivo() {
		boolean bandera = true;
		FileInputStream file;
		try {
			file = new FileInputStream(nombreArchivoPelicula);
			DataInputStream data= new DataInputStream(file);
			while(bandera) {
				Pelicula aux= new Pelicula();
				aux.setTitulo(data.readUTF());
				aux.setStock(data.readInt());
				agregarPelicula(aux);
			}
			data.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Guardado");
		}
	}	
}