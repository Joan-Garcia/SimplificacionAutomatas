package pruebas;

import estructura.Automata;
import simplificacionautomatas.Simplifica;

public class PruebaSimplifica {

  public static void main(String[] args) {
    String[] alfabeto = {"a", "b"};
    String[] estados = {"A", "B", "C", "D", "E", "F"};
    String [] estadosFinales = {"F"};
    
    Simplifica p = new Simplifica();
    Automata a = new Automata(alfabeto, estados, estadosFinales, "A");
    
    Automata reducido = p.algoritmo(a);
    
    System.out.println(reducido.getTablaTransiciones().toString());
                              
  }
}
