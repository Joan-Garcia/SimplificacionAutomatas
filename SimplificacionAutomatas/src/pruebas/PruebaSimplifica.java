package pruebas;

import estructura.Automata;
import simplificacionautomatas.Simplifica;

public class PruebaSimplifica {

  public static void main(String[] args) {
//    String[] alfabeto = {"a", "b"};
//    String[] estados = {"A", "B", "C", "D", "E", "F"};
//    String [] estadosFinales = {"F"};
//    
    Simplifica p = new Simplifica();
//    Automata a = new Automata(alfabeto, estados, estadosFinales, "A");
    String[] alfabeto = {"a", "b"};
    String[] estados = {"q0", "q1", "q2"};
    String[] estadosFinales = {"q0", "q2"};
    String estadoInicial = "q0";
    
    
    Automata a = new Automata(alfabeto, estados, estadosFinales, 
                                     estadoInicial);
    
    Automata reducido = p.algoritmo(a);
    
    System.out.println(reducido.getTablaTransiciones().toString());
                              
  }
}
