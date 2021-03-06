package com.register.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class ChangeCalculator {

    private JFrame frame;
    private JTextField totalAmount;
    private JTextField givenAmount;
    private JLabel lblChange;
    private JTextField changeAmount;
    private JButton btnReset;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ChangeCalculator window = new ChangeCalculator();
            window.frame.setVisible(true);
        });
    }

    public ChangeCalculator() {
        initialize();
    }

    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChangeCalculator.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        frame = new JFrame();
        frame.setTitle("Change Calculator");
        frame.setBounds(100, 100, 453, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);

        JLabel lblTotal = new JLabel("TOTAL");
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        lblTotal.setBounds(76, 83, 130, 34);
        frame.getContentPane().add(lblTotal);

        totalAmount = new JTextField();
        totalAmount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
        totalAmount.setHorizontalAlignment(SwingConstants.CENTER);
        totalAmount.addActionListener((ActionEvent arg0) -> {
        });
        totalAmount.setBounds(216, 86, 110, 34);
        frame.getContentPane().add(totalAmount);
        totalAmount.setColumns(10);

        JLabel lblGiven = new JLabel("GIVEN");
        lblGiven.setHorizontalAlignment(SwingConstants.CENTER);
        lblGiven.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        lblGiven.setBounds(76, 128, 130, 34);
        frame.getContentPane().add(lblGiven);

        givenAmount = new JTextField();
        givenAmount.setHorizontalAlignment(SwingConstants.CENTER);
        givenAmount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
        givenAmount.addActionListener((ActionEvent e) -> {
        });
        givenAmount.setColumns(10);
        givenAmount.setBounds(216, 131, 110, 34);
        frame.getContentPane().add(givenAmount);

        JLabel lblChangeCalculator = new JLabel("CHANGE CALCULATOR");
        lblChangeCalculator.setBackground(new Color(0, 0, 255));
        lblChangeCalculator.setForeground(Color.BLACK);
        lblChangeCalculator.setHorizontalAlignment(SwingConstants.CENTER);
        lblChangeCalculator.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblChangeCalculator.setBounds(10, 11, 414, 46);
        frame.getContentPane().add(lblChangeCalculator);

        lblChange = new JLabel("RETURN");
        lblChange.setHorizontalAlignment(SwingConstants.CENTER);
        lblChange.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
        lblChange.setBounds(76, 173, 130, 34);
        frame.getContentPane().add(lblChange);

        changeAmount = new JTextField();
        changeAmount.setBackground(SystemColor.text);
        changeAmount.setEditable(false);
        changeAmount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
        changeAmount.addActionListener((ActionEvent e) -> {
            changeAmount.getText();
        });
        changeAmount.setHorizontalAlignment(SwingConstants.CENTER);
        changeAmount.setColumns(10);
        changeAmount.setBounds(216, 176, 110, 34);
        frame.getContentPane().add(changeAmount);

        btnReset = new JButton("RESET");
        btnReset.addActionListener((ActionEvent e) -> {
            changeAmount.setText("");
            givenAmount.setText("");
            totalAmount.setText("");
        });
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        btnReset.setBackground(new Color(192, 192, 192));
        btnReset.setBounds(20, 240, 110, 34);
        frame.getContentPane().add(btnReset);

        JSeparator separator = new JSeparator();
        separator.setForeground(SystemColor.desktop);
        separator.setBounds(20, 68, 389, 2);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(SystemColor.desktop);
        separator_1.setBounds(20, 227, 389, 2);
        frame.getContentPane().add(separator_1);

        JButton btnCalculate = new JButton("GO");
        btnCalculate.addActionListener((ActionEvent arg0) -> {
            double cost = Double.parseDouble(totalAmount.getText());
            double customer = Double.parseDouble(givenAmount.getText());
            double change = cost - customer;

            if (change <= 0) {
                String Fchange = String.format("%.2f", change);
                changeAmount.setText("$"
                        + Fchange.substring(1, Fchange.length()));
            } else {
                JOptionPane.showMessageDialog(frame, "Check user amount!");
                changeAmount.setText("");
            }
        });
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        btnCalculate.setBackground(Color.LIGHT_GRAY);
        btnCalculate.setBounds(159, 240, 110, 34);
        frame.getContentPane().add(btnCalculate);

        JButton btnExit = new JButton("EXIT");
        btnExit.addActionListener((ActionEvent e) -> {
            frame = new JFrame("Exit");
            if (JOptionPane.showConfirmDialog(frame,
                    "Do you want to Exit? ", "Sales Management",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                System.exit(0);
            }
        });
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
        btnExit.setBackground(Color.LIGHT_GRAY);
        btnExit.setBounds(299, 240, 110, 34);
        frame.getContentPane().add(btnExit);
    }
}
