package simplificacionautomatas;

import estructura.Automata;

public class Simplifica {
    Moore equivalencia;
  public Simplifica(){
    equivalencia = new Moore();
  }
  
//  public void algoritmo(Automata a){
//    Automata b;
//    String[] estados;
//    estados = a.getEstados();
//    for (int i = 0; i < a.getEstados().length - 2; i++) {
//      b = a;
//        System.out.println("tamaño estados: "+estados.length+" estados[i]"+estados[i]);
//      a.setEstadoInicial(estados[i]);
//      b.setEstadoInicial(estados[i + 1]);
//      
//      if (equivalencia.algoritmo(a, b)) {
//        a.eliminaEstado(estados[i + 1], estados[i + 2]);
//      }
//    }
//  }
  
  public Automata algoritmo(Automata a){
    Automata b; 
    
    // Compara cada par de estados y verificar que son equivalentes: 
    for (int i = 0; i < a. getEstados().length; i++) {                          // Por cada par de estados del autómata a reducir
//      b = new Automata(a.getAlfabeto(), a.getEstados(), a.getEstadosFinales(),  // Crea una copia Mb
//                       a.getEstadoInicial( )); 
      b = a;
      for (int j = 0; j < b. getEstados().length - 1; j++) {                    // Recorre cada estado de Mb...
          System.out.println("Forj");
          System.out.println("Ma: "+a.getEstadoInicial()+" Mb: "+b.getEstadoInicial());
        if(a.getEstadoInicial().equals(b.getEstadoInicial())){                   // Menos el mismo estado.
          j++;                                                                  // Si es el mismo, pasa al siguiente.
            System.out.println("j++  "+j);
        }else{
          b.setEstadoInicial(b.getEstados()[j]);
            System.out.println("Cambia estado inicial de b: "+b.getEstados()[j]);
        }
          System.out.println("Compara la equivalencia de Ma: "+a.getEstadoInicial()+
                  " Mb: "+ b.getEstadoInicial());
        if(equivalencia.algoritmo(a, b)){                                        // Si los autómatas son equivalentes.
            System.out.println("EliminaEstado Ma: "+a.getEstadoInicial()+
                    " Mb: "+b.getEstadoInicial());
          a.eliminaEstado(a.getEstadoInicial(), b.getEstadoInicial());          //    Elimina de Ma el estado de Mb.
        }
      }
    
      a.setEstadoInicial(a.getEstados()[i]);                                    // Analiza el siguiente estado.
    }
    
    return a;
  }
}
