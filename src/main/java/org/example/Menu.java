package org.example;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu(){
        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(250, 250);
        setLocationRelativeTo(null);
        JButton snakeButton = new JButton("Snake Game");
        snakeButton.addActionListener(e -> {
            new SnakeWindow().setVisible(true);
        });
        JButton ticTacToeButton = new JButton("Tic Tac Toe Game");
        ticTacToeButton.addActionListener(e -> {

        });
        JButton sudokuButton = new JButton("Sudoku Game");
        sudokuButton.addActionListener(e -> {

        });
        setLayout(new GridLayout(3,1));
        add(snakeButton);
        add(ticTacToeButton);
        add(sudokuButton);
    }
}
