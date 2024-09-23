/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author HUYNH ANH
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.spi.CurrencyNameProvider;
import javax.swing.filechooser.FileSystemView;

public class JNotepad1 extends JFrame {
    private JTextArea textArea;

    public JNotepad1() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu formatMenu = new JMenu("Format");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveasMenuItem = new JMenuItem("SaveAs");
        JMenuItem pagesetupMenuItem = new JMenuItem("Page Setup...");
        JMenuItem printMenuItem = new JMenuItem("Print...");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        JMenuItem editMenuItem = new JMenuItem("Edit");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        newMenuItem.setAccelerator(KeyStroke.getKeyStroke('N', java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke('O', java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pagesetupMenuItem.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.event.InputEvent.CTRL_DOWN_MASK|java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        printMenuItem.setAccelerator(KeyStroke.getKeyStroke('P', java.awt.event.InputEvent.CTRL_DOWN_MASK));

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fc = new JFileChooser();             
                int r = fc.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
                    try {
                        // Create a file writer
                        FileWriter wr = new FileWriter(fi, false);
                        // Create buffered writer to write
                        BufferedWriter w = new BufferedWriter(wr);
                        // Write
                        w.write(textArea.getText());
                        w.flush();
                        w.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(fc, ex.getMessage());
                    }
                }

            }

        });

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn New JFileChooser jfc = new JFileChooser();                        
                textArea.setText("");

            }

        });
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn OpenJFileChooser fileChooser = new JFileChooser();
                JFileChooser fc = new JFileChooser("D:");
                int r = fc.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
                    try {
                        // String
                        String s1 = "", sl = "";
                        // File reader
                        FileReader fr = new FileReader(fi);
                        // Buffered reader
                        BufferedReader br = new BufferedReader(fr);

                        // Initialize sl
                        sl = br.readLine();

                        // Take the input from the file
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }

                        // Set the text ,i
                        textArea.setText(sl);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(fc, ex.getMessage());
                    }

                } // If the user cancelled the operation
                else {
                    JOptionPane.showMessageDialog(fc, "the user cancelled the operation");
                }

            }
        });
        copyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }

        });
        pasteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        pagesetupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
//         saveasMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                JFileChooser fc = new JFileChooser();             
//                int r = fc.showSaveDialog(null);
//                if (r == JFileChooser.APPROVE_OPTION) {
//                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
//                    try {
//                        // Create a file writer
//                        FileWriter wr = new FileWriter(fi, false);
//                        // Create buffered writer to write
//                        BufferedWriter w = new BufferedWriter(wr);
//                        // Write
//                        w.write(textArea.getText());
//                        w.flush();
//                        w.close();
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(fc, ex.getMessage());
//                    }
//                }
//            }
//        });
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveasMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(pagesetupMenuItem);
        fileMenu.add(printMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        var JMenu = menuBar.add(fileMenu);

        editMenu.add(editMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        JMenu = menuBar.add(editMenu);

        /*add*/
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.setJMenuBar(menuBar);
        this.add(scrollPane);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JNotepad1 notepad = new JNotepad1();
        });
    }
}
