package draft.ui;



import bracechecker.BraceChecker;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vahag on 10/1/2016.
 */
public class BraceCheckerFrame extends JFrame {
    JTextArea textArea;
    JTextField messageField;

    BraceCheckerFrame(){
        setTitle("Parse");

        JPanel btnPanel = new JPanel();
        JButton parseButton = new JButton("Parse");
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseActionPerformed();
            }
        });
        btnPanel.add(parseButton);

        Font f = new Font("",Font.BOLD,15);


        JScrollPane scrollPane = new JScrollPane();
        textArea = new JTextArea();
        scrollPane.getViewport().add(textArea);

        JPanel messageFieldPanel = new JPanel();

        messageField = new JTextField("No error");
        messageFieldPanel.add(messageField);
        messageField.setEnabled(false);
        messageField.setDisabledTextColor(Color.RED);
        messageField.setFont(f);

        setSize(500,400);
        setLocation(150,150);
        setVisible(true);
        add(btnPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(messageField, BorderLayout.SOUTH);



    }

    public void parseActionPerformed(){
        BraceChecker braceChecker = new BraceChecker();
        braceChecker.parse(textArea.getText());
        messageField.setText(braceChecker.getMessage());
    }

    public static void main(String[] args) {
        new BraceCheckerFrame();
    }
}
