package estructura;

import java.util.ArrayList; 
import java.util.Scanner;  

public class Automata {
  private final int numeroEstados, numeroSimbolos, numeroEstadosFinales;
  private final String[] alfabeto, estados, estadosFinales;
  private String estadoInicial;
  private final ArrayList <ArrayList<String>> tablaTransiciones;
  
  public Automata(String[] alfabeto, String[] estados, String[] estadosFinales,
                  String estadoInicial){
    tablaTransiciones = new ArrayList();
    
    this.alfabeto = alfabeto;
    this.estados = estados;
    this.estadosFinales = estadosFinales;
    this.estadoInicial = estadoInicial;
    
    numeroEstados = estados.length;
    numeroSimbolos = alfabeto.length;
    numeroEstadosFinales = estadosFinales.length;
    
    /*
      La tabla de transiciones tiene 3 columnas:
      | Estado actual / Símbolo / Estado siguiente |
      
      El número de filas es igual a el número de estados por el de símbolos.
    */    
    for (int i = 0; i < numeroEstados * numeroSimbolos; i++) {
      tablaTransiciones.add(new ArrayList());
    }
    this.capturarTablaTransiciones();
  }
  
  private void capturarTablaTransiciones() {
    int x = 0; 
    int y = 0; 
    
    for (int i = 0; i < tablaTransiciones.size(); i+=numeroSimbolos) {
      for (int j = i; j < i + numeroSimbolos; j++) {
        tablaTransiciones.get(j).add(estados[x]);
        tablaTransiciones.get(j).add(alfabeto[y]);
        System.out.print("Estado siguiente cuando " + estados[x] + " , " + 
                          alfabeto[y] + " :" );
        tablaTransiciones.get(j).add(new Scanner(System.in).nextLine());
        y++;
      }
      y = 0;
      x++;
    }    
  }
  
  public boolean esEstadoFinal(String estado){
    for (String estadoFinal : estadosFinales) 
      if (estadoFinal.equals(estado)) 
        return true;
   
    return false;
  }
  
  public String getEstadoSiguiente(String estado, String simbolo){
    String estadoSiguiente;
    estadoSiguiente = null;
    
    for (int i = 0; i < tablaTransiciones.size(); i++) {                          // Por cada fila
      if(tablaTransiciones.get(i).get(0).equals(estado))                               // Busca el estado, y si lo encuentras
        for (int j = 0; j < tablaTransiciones.get(i).size(); j++) {               // Por cada columna
          if(tablaTransiciones.get(i).get(j).equals(simbolo))                   // Busca el símbolo, y si lo encuentras
            estadoSiguiente = tablaTransiciones.get(i).get(2);                    // El estado siguiente está en la última columna
        }
    }
    
    return estadoSiguiente;
  }
  
  public void eliminaEstado(String q1, String q2) {                             // q2 es el estado que se va a eliminar
    for (int i = 0; i < tablaTransiciones.size(); i++) {                        // q1 es el estado equivalente de q2
      if(tablaTransiciones.get(i).get(0).equals(q2)) {                          // Por lo tanto todas las flechas que apunten a q2
        tablaTransiciones.remove(i);                                            // ahora apuntaran a q1.
        i--;
      }
      if(tablaTransiciones.get(i).get(2).equals(q2)) {
        tablaTransiciones.get(i).remove(2);
        tablaTransiciones.get(i).add(q1);
      }
    }
  }
  
  // --- Métodos de acceso ---
  
  public int getNumeroEstados() {
    return numeroEstados;
  }

  public int getNumeroSimbolos() {
    return numeroSimbolos;
  }

  public int getNumeroEstadosFinales() {
    return numeroEstadosFinales;
  }

  public String[] getAlfabeto() {
    return alfabeto;
  }

  public String[] getEstados() {
    return estados;
  }

  public String[] getEstadosFinales() {
    return estadosFinales;
  }

  public String getEstadoInicial() {
    return estadoInicial;
  }

  public ArrayList <ArrayList<String>> getTablaTransiciones() {
    return tablaTransiciones;
  }
  
  // Cambia el estado inicial del automata
  public void setEstadoInicial(String estado) {
    estadoInicial = estado;
  }
}
