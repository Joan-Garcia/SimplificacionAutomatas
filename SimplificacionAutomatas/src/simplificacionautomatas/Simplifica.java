package simplificacionautomatas;

import estructura.Automata;

public class Simplifica {

  public Automata algoritmo(Automata a){
    Automata b; 
    
    // Compara cada par de estados y verificar que son equivalentes: 
    for (int i = 0; i < a.getEstados().length; i++) {                           // Por cada par de estados del autómata a reducir
      // Clonación del objeto por constructor;
      b = new Automata(a);                                                      // Crea un máquina Mb
      
      for (int j = 0; j < b.getEstados().length; j++) {                         // Recorre cada estado de Mb...
        if(!a.getEstados()[i].equals(b.getEstados()[j])){                        // Menos el mismo estado. Si es el mismo, pasa al siguiente.
          b.setEstadoInicial(b.getEstados()[j]);
          if(new Moore().algoritmo(a, b))                                       // Si los autómatas son equivalentes.
            a.eliminaEstado(a.getEstadoInicial(), b.getEstadoInicial());        // Elimina de Ma el estado de Mb.
        }
      } 
      if((i + 1) != a.getEstados().length)                                      // Si hay un estado siguiente.
        a.setEstadoInicial(a.getEstados()[i + 1]);                              // Analiza el siguiente estado.
    }
    a.setEstadoInicial(a.getEstados()[0]);
    return a;
  }
}
