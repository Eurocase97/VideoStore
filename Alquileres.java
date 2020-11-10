package VideoStore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class Alquileres {
	HashMap<Integer, Ticket> alquileres;
	/*el numero clave del hash map es el numeroTicket*/
	public Alquileres() {
		alquileres=new HashMap<Integer, Ticket>();
	}
	
	public boolean addTicket(Integer numero, Ticket nuevo) {
		boolean rta=alquileres.containsKey(numero) ;
		if(rta) {
			alquileres.put(numero, nuevo);
		}
		return rta;
	}
	
	public Ticket getTicket(Integer numero) {
		Ticket aux=null;
		if(alquileres.containsKey(numero)) {
			aux=alquileres.get(numero);
		}
		return aux;
	}
	
	public ArrayList<Ticket> devolucionPordia(LocalDate fecha){
		ArrayList<Ticket> devoluciones= new ArrayList<>();
		Set<Entry<Integer, Ticket>> conjunto= alquileres.entrySet();
		Iterator<Entry<Integer, Ticket>> it= conjunto.iterator();
		
		while(it.hasNext()) {
			Ticket aux;
			Entry<Integer, Ticket> entrada= it.next();
			aux=entrada.getValue();
			if(aux.getFechaDeAlquiler()==fecha) {
				devoluciones.add(aux);
			}
		}
		return devoluciones;
	}

	public boolean devolucion(int numero) {
		boolean rta=alquileres.containsKey(numero) ;
		if(rta) {
			Ticket aux= alquileres.get(numero);
			aux.setDevolucion(true);
		}
		return rta;
	}
}