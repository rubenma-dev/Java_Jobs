/*4- Crear un programa en Java en el que se almacenen 3 números en 3 variables A, B y C.
El diagrama debe decidir cuál es el mayor y cual es el menor

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suma;

import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class E4 {
      public static void main(String[] args) {
        String n=JOptionPane.showInputDialog("Introduzca el primer numero:");
        int a=Integer.parseInt(n);
        
        n=JOptionPane.showInputDialog("Introduzca el segundo numero:");
        int b=Integer.parseInt(n);
        
        n=JOptionPane.showInputDialog("Introduzca el tercer numero:");
        int c=Integer.parseInt(n);
        
        if (a==b && a==c)
        {JOptionPane.showMessageDialog(null, "Los tres numeros son iguales;");
      }
      else if (a>b && a>c && b>c) 
      {JOptionPane.showMessageDialog(null, "El numero mayor es:" +a+ "y el numero menor es:" +c);
      }
      else if (a>b && a>c && c>b)
      {JOptionPane.showMessageDialog(null, "El numero mayor es:" +a+ "y el numero menor es:" +b);
      }
      else if (b>a && b>c && c>a)
      {JOptionPane.showMessageDialog(null, "El numero mayor es: " +b+ "y el numero menor es:" +a);
      }
      else if (b>a && b>c && a>c)
      {JOptionPane.showMessageDialog(null, "El numero mayor es: " +b+ "y el numero menor es:" +c);
      }
      else if (c>a && c>b && b>a)
      {JOptionPane.showMessageDialog(null, "El numero mayor es: " +c+ "y el numero menor es:" +a);
      }
      else if (c>a && c>b && a>b)
      {JOptionPane.showMessageDialog(null, "El numero mayor es: " +c+ "y el numero menor es:" +b);
            }
      }
}