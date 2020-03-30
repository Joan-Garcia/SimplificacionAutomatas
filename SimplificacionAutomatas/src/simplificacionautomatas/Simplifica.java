package simplificacionautomatas;

import estructura.Automata;

public class Simplifica {
    Moore equivalencia;
  public Simplifica(){
    equivalencia = new Moore();
  }
  
  public void algoritmo(Automata a){
    Automata b;
    String[] estados;
    estados = a.getEstados();
    for (int i = 0; i < a.getEstados().length - 2; i++) {
      b = a;
        System.out.println("tamaño estados: "+estados.length+" estados[i]"+estados[i]);
      a.setEstadoInicial(estados[i]);
      b.setEstadoInicial(estados[i + 1]);
      
      if (equivalencia.algoritmo(a, b)) {
        a.eliminaEstado(estados[i + 1], estados[i + 2]);
      }
    }
  }
}
