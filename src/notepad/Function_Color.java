/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepad;

import java.awt.Color;

/**
 *
 * @author franco
 */
public class Function_Color {
   Notepad n;
   
   public Function_Color(Notepad n){
       this.n = n;
   }
   
   public void changeColor(String c){
       
       switch(c){
           case "White":
               n.window.getContentPane().setBackground(Color.white);
               n.textArea.setBackground(Color.white);
               n.textArea.setForeground(Color.BLACK);
               break;
           case "Black":
               n.window.getContentPane().setBackground(Color.black);
               n.textArea.setBackground(Color.black);
               n.textArea.setForeground(Color.white);
               break;
       }
   }
}
