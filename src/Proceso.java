import java.util.Arrays;

import javax.swing.JOptionPane;

public class Proceso {
	
	Double Peso[],Altura[], ResultadoIMC[];
	String Nombre[];
	int Documento[], Telefono[];
	
	double IMC;
	
	String estado = "", mens = "";
	
	public void inicio() {
		
		String menu="MENU:\n";
		menu+="1. AGREGAR PERSONAS\n";
		menu+="2. BUSCAR RESULTADOS INDIVIDUALES\n";
		menu+="3. IMPRIMIR DATOS\n";
		menu+="4. SALIR\n";
		
		int rep = 0;
		do {
			rep= Integer.parseInt(JOptionPane.showInputDialog(menu));
			validaciondelmenu(rep);
		} while (rep !=4);
	}
	
	
	public void validaciondelmenu(int opcion) {
		switch (opcion) {
		case 1: 
			pedirdatos();
			break;
			
		case 2:
			if (Documento!=null) {
				 Diagnostico();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
			
		case 3:
			if (validarArreglo()) {
				MostrarInformacion();	
			}else {
				System.out.println("Debe primero llenar datos");
			}
			break;
		case 4: 
			System.out.println("saliendo del programa...");
			break; 
		default:
			System.out.println("ingrese una opcion valida");
		}
	}





	public boolean validarArreglo() {
		if (Nombre!=null) {
			return true;
		}else {
			System.out.println("Debe primero llenar datos");
			return false;
		}
	}
	
	
	public void pedirdatos() {
		
		System.out.println("llenar datos");
		int tamaño=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas"));
		Documento=new int[tamaño];
		ResultadoIMC=new Double[tamaño];
		Telefono=new int[tamaño];
		Peso=new Double[tamaño];
		Altura=new Double[tamaño];
		Nombre=new String[tamaño];
		
		for (int i = 0; i < Documento.length; i++) {
			Documento[i]=Integer.parseInt(JOptionPane.showInputDialog("ingrese el documento "+(i+1)));
			Nombre[i]=JOptionPane.showInputDialog("Ingrese el nombre "+(i+1));
			Telefono[i]=Integer.parseInt(JOptionPane.showInputDialog("ingrese el telefono"+(i+1)));
			Peso[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el peso "+(i+1)));
			Altura[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese la altura "+(i+1)));
			
			
			IMC=Peso[i]/(Altura[i]*Altura[i]);
			
			ResultadoIMC[i]=IMC;
			
		}
		
		
	}
	
	private void Diagnostico() {
		int buscarDocumento = Integer.parseInt(JOptionPane.showInputDialog("ingrese su documento"));
		int cont=0;
		
		for (int i = 0; i < Documento.length; i++) {
			if(IMC<18) {
				estado = "Anorexia";
			}else if(IMC>=18 && IMC<20) {
				estado = "Delgadez";
			}else if(IMC>=20 && IMC<27) {
				estado = "Normalidad";
			}else if(IMC>=27 && IMC<30) {
				estado = "Obesidad grado 1";
			}else if(IMC>=30 && IMC<35) {
				estado = "Obesidad grado 2";
			}else if(IMC>=35 && IMC<40) {
				estado = "Obesidad grado 3";
			}else if(IMC>=40) {
				estado = "Obesidad morbida";
			}
			
			if (Documento[i]==buscarDocumento) {
				mens="Hola "+Nombre[i]+", Con el documento "+ Documento[i]+"\n";
				mens+="Y telefono "+Telefono[i]+"\n. El resultado de su IMC es:  "+ ResultadoIMC[i]+"\n";
				mens+="usted padece de "+ estado;
				System.out.println(mens);
				cont++;
			}
		}
		if (cont==0) {
			System.out.println("La persona no existe");
		}
	}


	
	private void MostrarInformacion() {
		System.out.println("Informacion:\n");
		for (int i = 0; i < Nombre.length; i++) {
			System.out.println("Nombre: "+Nombre[i]+" Documento: "+Documento[i]+" Telefono: "+Telefono[i]+" Resultado: "+ResultadoIMC[i]);
		}
		
	}
}
	
	
