/*3- Desarrolle un programa en Java que permita leer un valor cualquiera N y escriba si dicho 
número es par o impar

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
public class E3 {
     public static void main(String[] args) {
         
     Scanner n = new Scanner(System.in);
        
     int n1;
     
     System.out.println("Por favor ingrese el numero a evaluar: ");
     n1 = n.nextInt();

     if(n1 % 2 == 0) {
         System.out.println(n1+" es un numero par");
     }
     else{
         System.out.println(n1+" es un numero impar");
     }
  }   
}
