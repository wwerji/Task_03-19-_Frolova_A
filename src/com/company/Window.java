package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {
    public Window() throws Exception {
        super("List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //открытие на весь экран = false
        setLocationRelativeTo(null); //расположение по центру
        setSize(1250, 200);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));


        Elements elements = new Elements();
        elements.input();


        panel.add(new JLabel("Write string: "));
        JTextField textField1 = new JTextField();
        panel.add(textField1);
        JButton input = new JButton("Input");
        panel.add(input);
        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(elements.getStr());//считываем строку с текстового файла input
            }
        };
        input.addActionListener(actionListener1);//при нажатии на кнопку input


        panel.add(new JLabel("SimpleLinkedListQueue №1: "));
        JTextField textField2 = new JTextField();
        panel.add(textField2);
        JButton output = new JButton("Output №1");
        panel.add(output);
        getContentPane().add(panel);//добавляет элементы
        ActionListener actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = textField1.getText();//считываем с текстового поля строку
                elements.setStr(a);//сортируем
                textField2.setText(elements.getStr2());//возвращаем в ответ
            }
        };
        output.addActionListener(actionListener2);//при нажатии на кнопку output

        panel.add(new JLabel("SimpleLinkedListQueue №2: "));
        JTextField textField3 = new JTextField();
        panel.add(textField3);
        JButton output2 = new JButton("Output №2");
        panel.add(output2);
        getContentPane().add(panel);//добавляет элементы
        ActionListener actionListener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = textField1.getText();//считываем с текстового поля строку
                elements.setStr2(a);//сортируем
                textField3.setText(elements.getStr3());//возвращаем в ответ
            }
        };
        output2.addActionListener(actionListener3);//при нажатии на кнопку output

    }
}

