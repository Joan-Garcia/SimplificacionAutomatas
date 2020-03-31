package PRUEBAS;

import datos.Captura;
import estructura.Automata;
import simplificacionautomatas.Moore;

public class AutomatasEquivalentes {
  Captura datosA, datosB;
  Automata automataA, automataB;
  Moore algoritmo;
  
  public AutomatasEquivalentes(){
    datosA = new Captura();
    datosB = new Captura();
    algoritmo = new Moore();
  }
  
  private void capturaDatos(){
    System.out.println("Automata 1");
    datosA.capturaDefinicionFormal();
    System.out.println("Automata 2");
    datosB.capturaDefinicionFormal();
    
    
    System.out.println("Transiciones de Automata 1");
    automataA = new Automata(datosA.getAlfabeto(), datosA.getEstados(), 
            datosA.getEstadosFinales(), datosA.getEstadoInicial());
    System.out.println("Transiciones de Automata 2");
    automataB = new Automata(datosB.getAlfabeto(), datosB.getEstados(), 
            datosB.getEstadosFinales(), datosB.getEstadoInicial());
  }
  
  private void evaluaEquivalencia(){
    if (algoritmo.algoritmo(automataA, automataB))
      System.out.println("Los automatas si son equivalentes");
    else 
      System.out.println("Los automatas no son equivalentes");
  }
  
  public static void main(String[] args) {
    AutomatasEquivalentes run = new AutomatasEquivalentes();
    
    run.capturaDatos();
    run.evaluaEquivalencia();
  }
    
}
