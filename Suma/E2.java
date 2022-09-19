/*2- Hacer un programa en Java que permita leer 2 números diferentes y nos diga cual es el mayor de 
los 2 números

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
public class E2 {
       public static void main(String[] args) {
        
        Scanner n = new Scanner(System.in);
        
        int n1;
        int n2;
        
        System.out.println("Ingresar el primer numero");
        n1 = n.nextInt();
        
        System.out.println("Ingresar el segundo numero");
        n2 = n.nextInt();
        
        if(n1>n2){
            System.out.println(n1+"es mayor que"+n2);
        }
        else{
            System.out.println(n2+"es mayor que"+n1);
        }     
    }
} 

