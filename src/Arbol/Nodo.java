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
public class Nodo {
    private int prioridad;
    private String tipo;
    private Object dato;
    Nodo hijo_izquierdo,hijo_derecho;

    public Nodo(Object dato,String tip,int prio, Nodo izq, Nodo der) {
        this.tipo = tip;
        this.prioridad = prio;
        this.dato = dato;
        this.hijo_izquierdo = izq;
        this.hijo_derecho = der;
    }
    
    public Nodo(){
        
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public int getPrioridad(){
        return prioridad;
    }
    
    public Object getDato(){
        return dato;
    }
    
    public void init(String tip,int prio,Object dato){
        this.tipo = tip;
        this.prioridad = prio;
        this.dato = dato;
}
    
}
