package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

/**
 * Created by Karen on 11/20/2016.
 */
public class NotepadFrame extends JFrame{
    TextArea textArea = new TextArea();
    JPanel controlPanel = new JPanel();
    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    JPanel savePanel = new JPanel();
    FileOutputStream file = null;

    NotepadFrame () {
        //Create the menu bar.
        menuBar = new JMenuBar();

//Build the first menu.
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_D);
        fileMenu.setMnemonic(KeyEvent.VK_A);
        fileMenu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

//a group of JMenuItems
        menuItem = new JMenuItem("New",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        fileMenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    newActionPerformed();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        menuItem = new JMenuItem("Open");
        menuItem.setMnemonic(KeyEvent.VK_B);
        fileMenu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_D);
        fileMenu.add(menuItem);

        menuItem = new JMenuItem("Save As");
        menuItem.setMnemonic(KeyEvent.VK_D);
        fileMenu.add(menuItem);

        menuItem = new JMenuItem("Undo");
        menuItem.setMnemonic(KeyEvent.VK_D);
        editMenu.add(menuItem);






        add(menuBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
      //  add(controlPanel, BorderLayout.NORTH);
        setBounds(150, 100, 500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




    public void newActionPerformed() throws IOException {
        int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
        if(textArea.getText() != ""){
            dialogButton = JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "NotePad",dialogButton) ;
            if(dialogButton == JOptionPane.YES_OPTION){
                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Save a File");
                fc.showSaveDialog(this);


                

                byte [] buf = textArea.getText().getBytes();
                try{
                    file = new FileOutputStream(fc.getApproveButtonText()+".txt");
                }catch (FileNotFoundException e){

                }
                for (int i = 0; i < buf.length; i++) {
                    file.write(buf[i]);
                }

            }
        }
        //textArea.append(textArea.getText());
        //textArea.setText("");
        //textArea.repaint();
    }

    public void saveNewFile(){

    }

    public static void main(String[] args) {
        new NotepadFrame();
    }
}
