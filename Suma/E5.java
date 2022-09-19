/*5- Crear un programa en Java para sumar 10 números leídos por teclado

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
public class E5 {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        int b;
        int c=0;
        
        System.out.println("Ingrese los numeros:");
        for (int  i=1; i <= 10; i++) {  
          b = n.nextInt();
          c = b+c;
        }
        System.out.println("El resultado de la suma es:" +c);
    }
}
