package com.javable.lessons.lesson9;

/**
 * Created by ruaval on 10.04.2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dialog4 extends JFrame {


    JTextField fldIn = new JTextField(20);
    JTextField fldOut = new JTextField(20);
    Dialog4() {

        super("Слушатели (listeners) полей и кнопок");

        JButton btn = new JButton("Нажать нежно");
        JLabel lblIn = new JLabel("Поле ввода");
        JLabel lblOut = new JLabel("Поле вывода");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(400, 150);
        Container c = getContentPane();
        JPanel jPanelIn = new JPanel();
        JPanel jPanelOut = new JPanel();
        JPanel jPanelbtn = new JPanel();
        //
        c.add(jPanelIn, BorderLayout.NORTH);
        c.add(jPanelOut, BorderLayout.CENTER);
        c.add(jPanelbtn, BorderLayout.SOUTH);
        //
        jPanelIn.add(lblIn, BorderLayout.CENTER);
        jPanelIn.add(fldIn, BorderLayout.CENTER);
        //
        jPanelOut.add(lblOut, BorderLayout.CENTER);
        jPanelOut.add(fldOut, BorderLayout.CENTER);
        //
        jPanelbtn.add(btn, BorderLayout.SOUTH);
        fldIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fldOut.setText("Введен текст:" + fldIn.getText());
            }
        });
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fldOut.setText("Нажата кнопка");
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog4();
    }
}
