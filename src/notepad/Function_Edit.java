/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepad;

/**
 *
 * @author franco
 */
public class Function_Edit {
 Notepad n;
 
 public Function_Edit(Notepad n){
     this.n = n;
 }
 
 public void undo(){
     n.um.undo();
 }
 public void redo(){
     n.um.redo();
 }
}
