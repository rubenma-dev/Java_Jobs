/*7- Hacer un programa que permita escribir los 20 primeros pares.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suma;


/**
 *
 * @author HP
 */
public class E7 {
    public static void main(String[] args) {
        
        int n = 1;
        
        for (n = 1; n <= 40; n++) {
            if(n%2 == 0) {
            System.out.println(n+ " Es par"); 
            }   
        }
    }
}
