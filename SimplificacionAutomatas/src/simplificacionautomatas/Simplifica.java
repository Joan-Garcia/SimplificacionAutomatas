package simplificacionautomatas;

import estructura.Automata;
import java.util.ArrayList;

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
//    String[] alfabeto, estados, estadosFinales;
//    String estadoInicial;
//    ArrayList <ArrayList<String>> tablaTransiciones;
    
    // Compara cada par de estados y verificar que son equivalentes: 
    for (int i = 0; i < a.getEstados().length; i++) {                          // Por cada par de estados del autómata a reducir
//      alfabeto = a.getAlfabeto();
//      estados = a.getEstados();
//      estadosFinales = a.getEstadosFinales();
//      estadoInicial = a.getEstadoInicial();
//      tablaTransiciones = a.getTablaTransiciones();
      
//      b = new Automata(alfabeto, estados, estadosFinales,  // Crea una copia Mb
//                       estadoInicial, tablaTransiciones);                                                                     
      b = (Automata)a.clone();
      for (int j = 0; j < b.getEstados().length; j++) {                    // Recorre cada estado de Mb...
//          System.out.println("Forj");
//          System.out.println("Ma: "+a.getEstadoInicial()+" Mb: "+b.getEstadoInicial());
        if(a.getEstados()[i].equals(b.getEstados()[j])){                        // Menos el mismo estado.
          // No hagas nada.                                                                  // Si es el mismo, pasa al siguiente.
        }else{
          b.setEstadoInicial(b.getEstados()[j]);
            
            //System.out.println("Cambia estado inicial de b: "+b.getEstados()[j]);
          
            System.out.println("Compara la equivalencia de Ma: "+a.getEstadoInicial()+
                  " Mb: "+ b.getEstadoInicial());
            System.out.println("Con estados finales de Ma: "+a.getEstadosFinales()[0]+
                  " Mb: "+ b.getEstadosFinales()[0]);
            System.out.println(equivalencia.algoritmo(a, b));
            
          if(equivalencia.algoritmo(b, a)){                                        // Si los autómatas son equivalentes.
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
