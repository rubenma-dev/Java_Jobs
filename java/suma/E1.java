/*1- Hacer un programa para sumar dos números leídos por teclado y escribir el resultado.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suma;

import java.util.Scanner;
/**
 
 * @author HP
 */
public class E1 {
    public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        
        int n1;
        int n2;
        int resultado;
        
        System.out.println("Ingresar el primer numero");
        n1 = n.nextInt();
        
        System.out.println("Ingresar el segundo numero");
        n2 = n.nextInt();
        
        resultado = n1 + n2;
        
        System.out.println("El resultado final es: "+resultado);         
    }
}