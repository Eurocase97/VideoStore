package VideoStore;

import java.time.LocalDate;
import java.util.Scanner;


public class VideoStore {

	public static void main(String[] args) {
		int menu;
		Catalogo catalogo= new Catalogo();
		Clientela clientela= new Clientela();
		Alquileres alquileres= new Alquileres();
		catalogo.cargarArchivo();
        
        do {
        	 Scanner sc = new Scanner(System.in);
        	 
        	 System.out.println("1-Alquilar pelicula\n");
             System.out.println("2-Devolver pelicula\n");
             System.out.println("3-Agregar pelicula\n");
             System.out.println("4-Eliminar pelicula\n");
             System.out.println("5-Mostrar catalogo\n");
             System.out.println("0-Para cerrar programa\n");
             
             menu=sc.nextInt();
        	  switch (menu) {
      		case 1: {
      				int control;
      				LocalDate hoy = LocalDate.now();
      				System.out.println("Ingrese titulo de pelicula\n");
      				Pelicula pelicula= catalogo.getPelicula(sc.next());
      				if(pelicula!=null) {
      					System.out.println("Pelicula encontrada\n");
      					if(pelicula.getStock()>=1) {
      						Cliente cliente= new Cliente();
      						System.out.println("------------Ingrese datos del cliente: ------------\n");
      						System.out.println("Ingrese dni del cliente: \n");
      						String dniCliente=sc.next();
      						if(clientela.containsCliente(dniCliente)){
      							cliente= clientela.getCliente(dniCliente);
      						}else {
      							cliente.setDni(dniCliente);
          						System.out.println("Ingrese nombre del cliente: \n");
          						cliente.setName(sc.next());
          						System.out.println("Ingrese direccion del cliente: \n");
          						cliente.setDireccion(sc.next());
          						System.out.println("Desea ingresar al usuario: "+cliente.toString()+"\n");
          						System.out.println("1-Si 2-No\n");
          						control=sc.nextInt();
          						if(control==1) {
          							clientela.agreagarCliente(cliente);
          						}
      						}
      						Ticket nuevoTicket= new Ticket(cliente, hoy, pelicula);
      						System.out.println("Ticket creado: "+ nuevoTicket.toString()+"\n");
      						alquileres.addTicket(nuevoTicket.getNumeroTicket(), nuevoTicket);
      						pelicula.restarCantidadStock(1);
      						
      					}else {
      						System.out.println("No hay mas Stock\n");
      					}
      				}else {
  						System.out.println("Pelicula no existente o mal escrito\n");
  					}
      			break;
      		}
      		case 2:{
      			System.out.println("ingrese numero de ticket\n");
      			Integer numeroTicket = sc.nextInt();
      			Ticket aux= alquileres.getTicket(numeroTicket);
      			if(aux!=null) {
      				aux.setDevolucion(true);
      				Pelicula auxP=aux.getPelicula();
      				auxP.sumarCantidadStock(1);
      				System.out.println("Devolucion\n");
      			}else {
      				System.out.println("Ticket no existe\n");
      			}
      			break;
      		}
      		case 3:{
      			Pelicula nuevaPelicula= new Pelicula();
      			int choos;
      			do {
      				System.out.println("Ingrese titulo\n");
          			nuevaPelicula.setTitulo(sc.next());
          			sc.next();
          			System.out.println("Ingrese stock\n");
          			nuevaPelicula.setStock(sc.nextInt());
          			System.out.println("Desea Ingresada: "+ nuevaPelicula.toString()+"\n");
          			System.out.println("1-Si\n");
          			System.out.println("2-No\n");
          			choos=sc.nextInt();
          			if(choos==1) {
          				if(catalogo.agregarPelicula(nuevaPelicula)) {
          					System.out.println("Pelicula Agregada con exito\n");
          				}else {
          					System.out.println("Ocurrio un erro. Quizas esta pelicula ya fue ingresada\n");
          				}
          			}
          			System.out.println("Desea ingresar otra pelicula? 1-si 2-no\n");
          			choos=sc.nextInt();
          			sc.next();
      			}while(choos==1);
      			catalogo.guardarCatalogo();
      			break;
      		}
      		case 4:{
      			System.out.println("Que pelicula Desea eliminar\n");
      			if(catalogo.eliminarPelicula(sc.next())) {
      				System.out.println("eliminado\n");
      			}else {
      				System.out.println("Algo salio mal. verifica que el nombre este escrito\n");
      			}
      			break;
      		}
      		case 5: {
      			System.out.println(catalogo.mostrarCatalogo());
      			break;
      			
      		}
      		case 0:{
      			System.out.println("chaito\n");
      			sc.close();
      			break;
      		
      		}
      		default:
      			System.out.println("opcion incorrercta\n");
      			break;
      		}
        }while(menu!=0); 
	}
}