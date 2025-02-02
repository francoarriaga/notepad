/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author franco
 */

public class Function_File {
    Notepad notepad;
    String fileName, fileAddress;
    
    public Function_File(Notepad notepad){
        this.notepad = notepad;
        
    }
    public void newFile(){
        notepad.textArea = new JTextArea("");
        notepad.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }
    public void open(){
        FileDialog fd = new FileDialog(notepad.window, "Open",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notepad.window.setTitle(fileName);
        }
        System.out.println("File address and file name: " + fileAddress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress +fileName));
            notepad.textArea.setText("");
            String line = null;
            
            while((line = br.readLine()) != null){
                notepad.textArea.append( line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File not opened!: "+e);
        }
    }
    
    public void save(){
        if(fileName == null){
            saveAs();
        }else{
            try {
               FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(notepad.textArea.getText());
            notepad.window.setTitle(fileName);
            fw.close();
            } catch (Exception e) {
            }
        }
    }
    public void saveAs(){
        FileDialog fd = new FileDialog(notepad.window, "Save",FileDialog.SAVE );
        fd.setVisible(true);
        
        if(fd.getFile() !=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            notepad.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(notepad.textArea.getText());
            fw.close();
        } catch (Exception e) {
        }
    }
    
    public void exit(){
        System.exit(0);
    }
}
