
package simplificacionautomatas;

import datos.Captura;
import estructura.Automata;
import java.util.Arrays;

public class SimplificacionAutomatas {
  Captura datosA;
  Automata a, reducido;
  Simplifica minimiza;
  public SimplificacionAutomatas() {
      datosA = new Captura();
      minimiza = new Simplifica();
  }
  
  private void capturaDatos() {
    datosA.capturaDefinicionFormal();
      
    System.out.println("Transiciones del Automata");
    a = new Automata(datosA.getAlfabeto(), datosA.getEstados(), 
            datosA.getEstadosFinales(), datosA.getEstadoInicial());
  }
  
  private void reduce() {
      reducido = minimiza.algoritmo(a);
  }
  
  private void resultados() {
    System.out.println("El automata reducido quedó de la siguiente manera");
    System.out.println("Alfabeto: " + arrayToString(a.getAlfabeto()));
    System.out.println("Estados: " + arrayToString(a.getEstados()));
    System.out.println("Estados Finales: " + arrayToString(a.getEstadosFinales()));
    System.out.println("Estado Inicial: " + a.getEstadoInicial());
    System.out.println("Transiciones: ");
    System.out.println(a.getTablaTransiciones().toString());
  }
  
  private static String arrayToString(String[] s) {
    return Arrays.toString(s);
  }
  public static void main(String[] args) {
    SimplificacionAutomatas run = new SimplificacionAutomatas();
    
    run.capturaDatos();
    run.reduce();
    run.resultados();
  }
    
}
