/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author necro
 */
public class TestArbol {

    @SuppressWarnings("empty-statement")
    public static String[] formato(String caracter){
     Pattern pat = Pattern.compile("[0123456789]");
     Matcher mat = pat.matcher(caracter);
     String[] datos = new String[3];
     if (mat.find()) {
         datos[0]=caracter; datos[1]="operando"; datos[2]="-1";
         return datos;
     } 
     switch(caracter){
         case "*": datos[0]=caracter; datos[1]="operador"; datos[2]="4";
            break;
         case "/": datos[0]=caracter; datos[1]="operador"; datos[2]="3";
         break;
         case "+": datos[0]=caracter; datos[1]="operador"; datos[2]="2";
         break;
         case "-": datos[0]=caracter; datos[1]="operador"; datos[2]="1";
         break;
         case "=": datos[0]=caracter; datos[1]="operador"; datos[2]="0";
         break;
         case "(": datos[0]=caracter; datos[1]="parentesis_abrir"; datos[2]="-1";
         break;
         case ")": datos[0]=caracter; datos[1]="parentesis_cerrar"; datos[2]="-1";
         break;
     }
        return datos;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol  gramatical= new Arbol();
        String cad = "5+2*1=9/(3+5)";
        for(int i = 0; i<cad.length(); i++){
            String[] datos = formato(cad.charAt(i)+"");
            System.out.println(gramatical.crear(datos[0], datos[1], Integer.parseInt(datos[2])));
        }
        
        
    }
    
}
