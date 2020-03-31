package pruebas;

import estructura.Automata;
import simplificacionautomatas.Simplifica;

public class PruebaAutomata {
  public static void main(String[] args) {
    String[] alfabeto = {"a", "b"};
    String[] estados = {"q0", "q1", "q2"};
    String[] estadosFinales = {"q0", "q2"};
    String estadoInicial = "q0";
    
    
    Automata a = new Automata(alfabeto, estados, estadosFinales, 
                                     estadoInicial);
    System.out.println(a.getTablaTransiciones().toString());
    
    Simplifica p = new Simplifica();
//    p.algoritmo(a);
    
//    a.eliminaEstado("q2", "q1");
//    Automata reducido = p.algoritmo(a);
      System.out.println("Estado inicial: "+a.getEstadoInicial());
      a.setEstadoInicial("q1");
      System.out.println("Estado inicial: "+a.getEstadoInicial());
    
//    System.out.println(reducido.getTablaTransiciones().toString());
  }
}
