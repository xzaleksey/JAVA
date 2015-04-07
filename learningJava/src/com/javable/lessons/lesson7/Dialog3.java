package com.javable.lessons.lesson7;

/**
 * Created by ruaval on 07.04.2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Dialog3 extends JFrame {
    private static final String ENCODING_UTF8 = "UTF-8";
    JTextArea txt;

    Dialog3(String s) {
        super(s);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(400, 200);
        Container c = getContentPane();
        c.add(new JLabel("Hello, привет"), BorderLayout.NORTH); // 0
        txt = new JTextArea(5, 30);                             // 1
        JScrollPane pane = new JScrollPane(txt);                // 2
        c.add(pane, BorderLayout.CENTER);                       // 3
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    public Dialog3() {
        main();
    }

    public static void main() {
        Dialog3 d = new Dialog3("Визульное приложения с текстовой областью");
        d.test();
    }

    public void test() {
        txt.append("Первая строка\n");
        txt.append("Вторая строка\n");
    }
}