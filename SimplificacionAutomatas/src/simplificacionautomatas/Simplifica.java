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
        if(a.getEstados()[i].equals(b.getEstados()[j])){                        // Menos el mismo estado.
          // No hagas nada.                                                     // Si es el mismo, pasa al siguiente.
        }else{
          b.setEstadoInicial(b.getEstados()[j]);
                      
//          System.out.println("Compara la equivalencia de Ma: "+a.getEstadoInicial()+
//                " Mb: "+ b.getEstadoInicial());
//          System.out.println("Con estados finales de Ma: "+a.getEstadosFinales()[0]+
//                " Mb: "+ b.getEstadosFinales()[0]);
//            
          if(new Moore().algoritmo(a, b)){                                      // Si los autómatas son equivalentes.
            System.out.println("EliminaEstado Ma: "+a.getEstadoInicial()+
                    " Mb: "+b.getEstadoInicial());
          a.eliminaEstado(a.getEstadoInicial(), b.getEstadoInicial());          //    Elimina de Ma el estado de Mb.
          }  
        }   
      } 
      if((i + 1) != a.getEstados().length)                                      // Si hay un estado siguiente.
        a.setEstadoInicial(a.getEstados()[i + 1]);                              // Analiza el siguiente estado.
    }  
    return a;
  }
}
