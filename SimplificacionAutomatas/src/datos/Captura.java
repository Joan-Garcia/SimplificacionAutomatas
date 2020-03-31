package datos;

import java.util.Scanner;

public class Captura {
  private String[] alfabeto, estados, estadosFinales;
  private String estadoInicial;
  private final Scanner entrada;

  public Captura(){
    entrada = new Scanner(System.in);
  }

  public void capturaDefinicionFormal(){
    System.out.println("Ingrese los datos solicitados del automata");
    System.out.print("Ingrese el alfabeto (Separado por comas ','): ");
    alfabeto = entrada.nextLine().split(",");
    System.out.print("Ingrese los estados (Separado por comas ','): ");
    estados = entrada.nextLine().split(",");
    System.out.print("Ingrese los estados finales (Separado por comas ','): ");
    estadosFinales = entrada.nextLine().split(",");
    System.out.print("Ingrese el estado inicial: ");
    estadoInicial = entrada.nextLine();
  }

  public String[] getAlfabeto(){
    return alfabeto;
  }

  public String[] getEstados(){
    return estados;
  }

  public String[] getEstadosFinales(){
    return estadosFinales;
  }

  public String getEstadoInicial(){
    return estadoInicial;
  }
}