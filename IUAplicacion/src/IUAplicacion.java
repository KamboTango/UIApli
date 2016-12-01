/*Este ejemplo muestra el manejo del estado de forma local,
 * dejando como global aquella parte del estado representado
 * por las variables que sirven de apoyo pero que no son la
 * parte fundamental del procesamiento de la aplicación
 * 
 * 1. Esencial:
 *			 votos, ciudades (vitales para el procesamiento)
 * 
 * 2. De apoyo que se requieren conocer en diferentes rutinas: 
 *			in, out (globales a los métodos de la clase, locales a la clase)
 *			ciudadesReg	(global al sistema)
 * 
 * 3. De apoyo que no se requieren conocer en todas las rutinas:
 * (aparecen en cada rutina y por ningun motivo deben ser declaradas globales,
 * pues complican el diseño de la aplicación y hacen difícil localizar los
 * errores cuando cambian su valor con datos incorrectos) 
 * 
 * Ej.  En main: opcion, noSalir
 *		En leerOpcion: opcion
 *		En ejecutarAccion: noSalir
 * 
 *	(Por favor,estas últimas, no las declare global a los métodos de la clase)		
 */



import java.io.*;

public class IUAplicacion{

	public static int ciudadesReg=2;

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;	// variables objetos in y out para
	 
	
	public static void main(String[] args)throws java.io.IOException{
		
		int[]votos= new int[5];
		String[] ciudades=new String[5];
		
		
		int opcion;
		boolean noSalir = true;

		do{
			mostrarMenu();
			opcion = leerOpcion();
			noSalir = ejecutarAccion(opcion,votos,ciudades);

		}while (noSalir);	
	}



	static void mostrarMenu(){

		out.println();
		out.println("Con variables locales en IU");
		out.println();
		out.println("1.  Agregar votos.");
		out.println("2.  Total votos.");
		out.println("3.  Mayor numero votos.");
		out.println("4.  Salir.");
		out.println();
	}


	static int leerOpcion()throws java.io.IOException{
				
		int opcion;

		out.print("Seleccione su opci\u00a2n: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}


	static boolean ejecutarAccion(int popcion,int[]pvotos,String[]pciudades)throws java.io.IOException{

		
		boolean noSalir = true;
				
		switch(popcion){			

			case 1: //Opcion Agregar Votos

				agregarVotos(pvotos, pciudades);
				break;

			case 2:// 'Opcion Total de votos registrados

				out.println();
				out.println("Se han recibido " + Rutinas.calcularTotalVotos(pvotos) + " votos");
				break;

			case 3: //Obtener mayor numero de votos

				int indice;			
				indice = Rutinas.obtenerMayorVotos(pvotos);
				out.println("La ciudad " + pciudades[indice] + " tiene " + pvotos[indice] + " votos");

				break;


			case 4: //Salir de la aplicacion

				noSalir = false;
				break;

			default: //Cualquier otro valor dado por el usuario se considera inválido

				out.println("Opcion inv\u00a0lida");
				out.println();
				break;
		}
		return noSalir;
	}


	static void agregarVotos(int[]pvotos, String[]pciudades)throws java.io.IOException {

		int ciudadesReg=0;
		
		out.print("Deme el nombre de la ciudad: ");
		pciudades[ciudadesReg] = in.readLine();
		out.println();

		out.print("Deme el n\u00a3mero de votos: ");
		pvotos[ciudadesReg] = Integer.parseInt(in.readLine());
		out.println();

		ciudadesReg++;
		//es igual a escribir ciudadesReg = ciudadesReg + 1;
		//o tambien ciudadesReg += 1;
	}

}
