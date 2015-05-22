package apps.GURPS;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class MainWindow extends JFrame {
    public MainWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
    }

    public static void main(String[] args) {
//        JTextField[] jTextFields = {new JTextField("10",2),new JTextField("10",2),new JTextField("10",2),new JTextField("10",2)};
        MainWindow mainWindow = new MainWindow("Калькулятор очков");
        JPanel jpanel = new JPanel();
        jpanel.setSize(40, 200);
//        for (JTextField jTextField : jTextFields) {
//            jpanel.add(jTextField);
//
//        }
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setPlaceholderCharacter('_');
        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(2);
        textField.setValue(new Double(10));
        jpanel.add(textField);
        mainWindow.add(jpanel, BorderLayout.WEST);
        mainWindow.setVisible(true);


    }
}
