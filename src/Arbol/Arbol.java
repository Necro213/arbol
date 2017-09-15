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
    public boolean crear(Object dato,String tipo,int prioridad){
        if(tipo.equals("parentesis_abrir") && raiz==null){
            raiz = new Nodo();
            raiz.hijo_izquierdo = new Nodo();
            t2 = raiz.hijo_izquierdo;
            return true;
        }
        if(raiz==null){
            temp = new Nodo(dato,tipo,prioridad,null,null);
            raiz = temp;
            return true;
        }
        temp = new Nodo(dato,tipo,prioridad,null,null);
        return acomodar(raiz);
    }
    
    public boolean acomodar(Nodo actual){
        if(t2 != null){
            actual = t2;
        }
        if(temp.getTipo().equals("parentesis_cerrar")){
            t2 = null;
            return true;
        }
        if(actual.getDato() == null){
            actual.init(temp.getTipo(),temp.getPrioridad(),temp.getDato());
            return true;
        }
        if(actual.hijo_derecho != null && actual.hijo_derecho.getTipo().equals("operador")){
             if(actual.getPrioridad() > temp.getPrioridad() && temp.getTipo().equals("operador")){
                temp.hijo_izquierdo = actual;
                if(actual == raiz){
                    raiz = temp;
                }
                return true;
            }
         return  acomodar(actual.hijo_derecho);
         
        }
        
        if(temp.getTipo().equals("parentesis_abrir")){
            actual.hijo_derecho = new Nodo();
          t2 = actual.hijo_derecho;
          return true;
        }
        
        if(actual.getTipo().equals("operando") && temp.getTipo().equals("operador")){
            Nodo save = new Nodo();
            save.init(actual.getTipo(), actual.getPrioridad(), actual.getDato());
            actual.init(temp.getTipo(), temp.getPrioridad(), temp.getDato());
            actual.hijo_izquierdo = save;
            return true;
        }
        if(actual.getTipo().equals("operador") && temp.getTipo().equals("operando")){
            actual.hijo_derecho = temp;
            return true;
        }
        if(actual.getTipo().equals("operador") && temp.getTipo().equals("operador")){
            if(actual.getPrioridad() > temp.getPrioridad()){
                temp.hijo_izquierdo = actual;
                if(actual == raiz){
                    raiz = temp;
                }
                return true;
            }
            if(actual.getPrioridad() < temp.getPrioridad()){
                if(actual.hijo_derecho != null && actual.hijo_derecho.getTipo().equals("operando")){
                    temp.hijo_izquierdo = actual.hijo_derecho;
                    actual.hijo_derecho = temp;
                    return true;
                }
            }
        }
        return false;
    }
}
