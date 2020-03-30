package simplificacionautomatas;

import estructura.Automata;

public class Simplifica {
    Moore equivalencia;
  public Simplifica(){
    equivalencia = new Moore();
  }
  
  public void algoritmo(Automata a){
    Automata b = a;
    String[] estados;
    estados = a.getEstados();
    for (int i = 0; i < a.getEstados().length; i++) {
      a.setEstadoInicial(estados[i + 1]);
      b.setEstadoInicial(estados[i + 2]);
      
      if (equivalencia.algoritmo(a, b)) {
        
      }
    }
  }
}
