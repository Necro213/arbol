/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author necro
 */
public class Arbol {
    private Nodo temp,raiz,t2;
    public void crear(Object dato,String tipo,int prioridad){
        if(tipo.equals("parentesis_abrir") && raiz==null){
            raiz = new Nodo();
            raiz.hijo_izquierdo = new Nodo();
            t2 = raiz.hijo_izquierdo;
            return;
        }
        if(raiz==null){
            temp = new Nodo(dato,tipo,prioridad,null,null);
            raiz = temp;
            return;
        }
        temp = new Nodo(dato,tipo,prioridad,null,null);
        acomodar(raiz);
    }
    
    public void acomodar(Nodo actual){
        if(t2 != null){
            actual = t2;
        }
        if(temp.getTipo().equals("parentesis_cerrar")){
            t2 = null;
            return;
        }
        if(actual.getDato() == null){
            actual.init(temp.getTipo(),temp.getPrioridad(),temp.getDato());
            return;
        }
        if(actual.hijo_derecho != null && actual.hijo_derecho.getTipo().equals("operador")){
            acomodar(actual.hijo_derecho);
        }
        
        if(temp.getTipo().equals("parentesis_abrir")){
            actual.hijo_derecho = new Nodo();
          t2 = actual.hijo_derecho;
          return;
        }
        
        if(actual.getTipo().equals("operando") && temp.getTipo().equals("operador")){
            Nodo save = new Nodo();
            save.init(actual.getTipo(), actual.getPrioridad(), actual.getDato());
            actual.init(temp.getTipo(), temp.getPrioridad(), temp.getDato());
            actual.hijo_izquierdo = save;
            return;
        }
        if(actual.getTipo().equals("operador") && temp.getTipo().equals("operando")){
            actual.hijo_derecho = temp;
            return;
        }
        if(actual.getTipo().equals("operador") && temp.getTipo().equals("operador")){
            if(actual.getPrioridad() > temp.getPrioridad()){
                temp.hijo_izquierdo = actual;
                actual = temp.hijo_izquierdo;
                return;
            }
            if(actual.getPrioridad() < temp.getPrioridad()){
                if(actual.hijo_derecho != null && actual.hijo_derecho.getTipo().equals("operando")){
                    temp.hijo_izquierdo = actual.hijo_derecho;
                    actual.hijo_derecho = temp;
                    return;
                }
            }
        }
    }
}
