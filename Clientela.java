package VideoStore;

import java.util.HashMap;

public class Clientela {
	private HashMap<String, Cliente> clientela;
	
	public Clientela() {
		clientela= new HashMap<String, Cliente>();
	}
	
	public boolean agreagarCliente(Cliente ingreso) {
		boolean rta= clientela.containsKey(ingreso.getDni());
		if(!rta) {
			clientela.put(ingreso.getDni(), ingreso);
		}
		return rta;
	}
	
	public Cliente getCliente(String Dni) {
		Cliente aux= null;
		if(clientela.containsKey(Dni)) {
			aux=clientela.get(Dni);
		}
		return aux;
	}
	
	public boolean containsCliente(Cliente ingreso) {
		  return clientela.containsKey(ingreso.getDni());
	}
	
	public boolean containsCliente(String ingreso) {
		  return clientela.containsKey(ingreso);
	}
}