package bracechecker.ui;
import bracechecker.BraceChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BraceCheckerFrame extends JFrame {


    private JTextArea textArea;
    private JTextField messageField;

    BraceChecker braceChecker;


    public BraceCheckerFrame() {
        setTitle("Parser");

        JPanel btnPanel = new JPanel();
        JButton parseBtn = new JButton("Parse");
        parseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseActionPerformed();
            }
        });

        btnPanel.add(parseBtn);

        JScrollPane scrollPane = new JScrollPane();
        textArea = new JTextArea();
        scrollPane.getViewport().add(textArea);

        JPanel messageFieldPanel = new JPanel();

        messageField = new JTextField("No Error");
        messageField.setEnabled(false);
        GridLayout gridLayout = new GridLayout(1, 1);
        messageFieldPanel.setLayout(gridLayout);
        messageFieldPanel.add(messageField );

        add(btnPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(messageFieldPanel, BorderLayout.SOUTH);

        setLocation(150, 100);
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }


    private void parseActionPerformed(){
        braceChecker = new BraceChecker();
        braceChecker.parse(textArea.getText());
        messageField.setText(braceChecker.getMessage());
    }

    public static void main(String[] args) {
        new BraceCheckerFrame();
    }
}
