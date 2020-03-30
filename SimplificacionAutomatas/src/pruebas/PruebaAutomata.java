package pruebas;

import estructura.Automata;
import simplificacionautomatas.Simplifica;

public class PruebaAutomata {
  public static void main(String[] args) {
    String[] alfabeto = {"a", "b"};
    String[] estados = {"q0", "q1", "q2"};
    String[] estadosFinales = {"q0", "q2"};
    String estadoInicial = "q0";
    
    
    Automata automata = new Automata(alfabeto, estados, estadosFinales, 
                                     estadoInicial);
    System.out.println(automata.getTablaTransiciones().toString());
    
    Simplifica algoritmo = new Simplifica();
    algoritmo.algoritmo(automata);
    
//    automata.eliminaEstado("q2", "q1");
    
    System.out.println(automata.getTablaTransiciones().toString());
  }
}
