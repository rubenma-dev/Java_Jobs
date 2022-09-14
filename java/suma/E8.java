/*8- Hacer un programa en Java que lea N números, calcule y escriba la suma de los pares 
y el producto de los impares.

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
public class E8 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner (System.in);
        int numero;
        int inicial = 0;
        int suma = 0;
        int producto = 1;
        
        System.out.print("Introduce un numero: ");
        numero = tecla.nextInt();
        
        while(inicial < numero)
        {
            if(inicial%2==0)
            {
                suma = suma + inicial;
            }
            else
            {
                    producto = producto * inicial;        
            }
            inicial++;
        }
        
        System.out.println("\n La suma de los numeros pares es: "+suma);
        System.out.println("\n El producto de los numeros impares es: "+producto);
    }
}
