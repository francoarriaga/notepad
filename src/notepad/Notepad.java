/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author franco
 */
public class Notepad implements ActionListener{
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    Function_File file = new Function_File(this);
    Function_Format ff = new Function_Format(this);
    JMenuItem iWrap, iFontArial, iFontComic, iFontSize8, iFontSize12;
    JMenu menuFont, menuFontSize;
    boolean wWrap = false;
    JMenuItem color1, color2;
    Function_Color fc = new Function_Color(this);
    JMenuItem undo, redo;
    UndoManager um = new UndoManager();
    Function_Edit fe = new Function_Edit(this);
    String meme;
    
    public static void main(String[] args) {
        new Notepad();
    }
    public Notepad(){
        createWindow();
         createMenuBar();
        createTextArea();
        creteFileMenu();
        createFormatMenu();
        ff.selectedFont = "Arial";
        ff.createFont(8);
        ff.wordWrap();
        createColorMenu();
        createEditMenu();
        window.setVisible(true);
    }
    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
    }
    public void createTextArea(){
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        //window.add(textArea);
    }
    
    public void createMenuBar(){
        menuBar =  new JMenuBar();
        window.setJMenuBar(menuBar);
        
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    
    public void creteFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        
        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);
        
        iSave = new JMenuItem("Save");
         iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);
        
        iSaveAs = new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);
        
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commnand = e.getActionCommand();
        switch(commnand){
            case "New": file.newFile(); 
            break;
            
            case "Open": file.open();
            break;
            
            case "Save":file.save();
            break;
            
            case "SaveAs": file.saveAs();
            break;
            
            case "Exit": file.exit();
            break;
            
            case "Redo": fe.redo();
            break;
            
        case "Undo": fe.undo();
            break;
            
            case "Word Wrap": ff.wordWrap();
            break;
            
            case "Arial": ff.setFont(commnand);
            
             case "Comic": ff.setFont(commnand);
            
            case "Size8": ff.createFont(8);
            break;
            
            case "Size12": ff.createFont(28);
            break;
            
            case "Black": fc.changeColor(commnand); 
            break;
            
            case "White": fc.changeColor(commnand);
            break;
        }
    }
    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);
        
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        
        iFontComic = new JMenuItem("Comic");
        iFontComic.addActionListener(this);
        iFontComic.setActionCommand("Comic");
        menuFont.add(iFontComic);
        
        iFontSize8 = new JMenuItem("Size8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size8");
        menuFontSize.add(iFontSize8);
        
        iFontSize12 = new JMenuItem("Size12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("Size12");
        menuFontSize.add(iFontSize12);
        
    }
    public void createColorMenu(){
        color1 = new JMenuItem("Black");
        color1.addActionListener(this);
        color1.setActionCommand("Black");
        menuColor.add(color1);
        
        color2 = new JMenuItem("White");
        color2.addActionListener(this);
        color2.setActionCommand("White");
        menuColor.add(color2);
    }
    
    public void createEditMenu(){
        undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        menuEdit.add(undo);
        
        redo = new JMenuItem("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        menuEdit.add(redo);
    }
}
