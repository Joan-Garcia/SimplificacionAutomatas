package simplificacionautomatas;

import estructura.Automata;
import java.util.ArrayList;

public class Moore {
  private final ArrayList <ArrayList<String>> tablaComparacion;
  
  public Moore(){
    tablaComparacion = new ArrayList();
    tablaComparacion.add(new ArrayList());
    tablaComparacion.add(new ArrayList());
  }
  
  public boolean algoritmo(Automata a, Automata b){
    boolean existen;
    // Guarda el estado de cada automata a analizar, empezando por los iniciales
    String[] parDeEstados = {a.getEstadoInicial(), b.getEstadoInicial()};
    
    tablaComparacion.get(0).add(parDeEstados[0]);
    tablaComparacion.get(1).add(parDeEstados[1]);
    
    // Itera hasta que no haya otro par de estados que evaluar
    for (int i = 0; i < tablaComparacion.get(0).size(); i++) {

      // Comprobar si el par de estados son compatibles, si no lo son, los
      // automatas no pueden ser equivalentes, entonces para el método y 
      // devuelve falso.
      if(!sonEquivalentes(a, b, parDeEstados[0], parDeEstados[1]))
        return false;
      
      // Obtiene el siguiente par a analizar, para cada símbolo del alfabeto.
      for (int j = 0; j < a.getAlfabeto().length; j++) {
        existen = false;
        parDeEstados[0] = a.getEstadoSiguiente(parDeEstados[0], a.getAlfabeto()[j]);
        parDeEstados[1] = b.getEstadoSiguiente(parDeEstados[1], b.getAlfabeto()[j]);
        
        // Comprobar que el par de estados no esté en la lista de comparación
        for (int k = 0; k < tablaComparacion.get(0).size(); k++) {
          if(tablaComparacion.get(0).get(k).equals(parDeEstados[0]))
            if(tablaComparacion.get(1).get(k).equals(parDeEstados[1]))
              existen = true; // Ya existen en la lista de comparación
        }
        
        // Si el par de estados no existe, agregalos.
        if(existen == false){
          tablaComparacion.get(0).add(parDeEstados[0]);
          tablaComparacion.get(1).add(parDeEstados[1]);
        }
      }
      
      // El próximo par a analizar, es el siguiente de la tabla de comparación.
      // Si ya no hay siguiente, termina la ejecucion:
      if( (i + 1) > tablaComparacion.get(0).size())
        return true;
      else {
        parDeEstados[0] = tablaComparacion.get(0).get(i);
        parDeEstados[1] = tablaComparacion.get(1).get(i);
      }
    }    
    
    // Ya no hay otro par que evaluar, entonces son equivalentes.
    return true;
  }
  
  public boolean sonEquivalentes(Automata a, Automata b, String qa, String rb){
    return a.esEstadoFinal(qa) == b.esEstadoFinal(rb);
  }
}