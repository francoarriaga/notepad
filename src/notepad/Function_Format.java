/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepad;

import java.awt.Font;

/**
 *
 * @author franco
 */
public class Function_Format {
    Notepad n;
    Font arial, comic, times;
    String selectedFont;
    public Function_Format(Notepad n){
        this.n = n;
    }
    
   public void wordWrap(){
       if((n.wWrap)== false ){
           n.wWrap = true;
           n.textArea.setLineWrap(true);
           n.textArea.setWrapStyleWord(true);
           n.iWrap.setText("Word Wrap: On");
       }else if((n.wWrap) == true){
           n.wWrap = true;
           n.textArea.setLineWrap(false);
           n.textArea.setWrapStyleWord(false);
           n.iWrap.setText("Word Wrap: Off");
       }
   }
   public void createFont(int fontSize){
       arial = new Font("Arial", Font.PLAIN, fontSize);
       comic = new Font("Comic Sans MS", Font.PLAIN  , fontSize);
       setFont(selectedFont);
   }
   public void setFont(String font){
       selectedFont = font;
       
       switch(selectedFont){
           case "Arial": n.textArea.setFont(arial);
           break;
           case "Comic": n.textArea.setFont(comic);
           break;
       }
   }
           
           
}
