/*6- Modificar el programa de la Tarea 6 para que permita sumar N números. 
El valor de N se debe leer previamente por teclado.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suma;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class E6 {
        public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        int a;
        int b;
        int c=0;

        System.out.println("Ingrese la cantidad de numeros que va a ingresar:");
        a = n.nextInt();
        
        System.out.println("Ingrese los numeros:");
        for (int i=0; i < a; i++) {
          b = n.nextInt();
          c = b+c;
        }
        System.out.println("El resultado de la suma es:" +c);
    }
}
