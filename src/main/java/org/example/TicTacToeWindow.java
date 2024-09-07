package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeWindow extends JDialog implements ActionListener {

    private JLabel playerTurnLabel = new JLabel();
    private String playerTurn = "Player Turn: ";
    private JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'X';
    private boolean gameOver = false;
    private boolean tie = false;


    TicTacToeWindow() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(725, 300, 480, 480);
        playerTurnLabel.setText(playerTurn + currentPlayer);
        add(playerTurnLabel, BorderLayout.NORTH);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                buttonsPanel.add(buttons[i][j]);
            }
        }
        add(buttonsPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!gameOver && clickedButton.getText().isEmpty()) {
            clickedButton.setText(String.valueOf(currentPlayer));
            checkForWin();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            playerTurnLabel.setText(playerTurn + currentPlayer);
        }

    }

    private void checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().isEmpty()) {
                gameOver = true;
            }else if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().isEmpty()) {
                gameOver = true;
            }
        }

        if(buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().isEmpty()){
            gameOver = true;
        } else if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().isEmpty()) {
            gameOver = true;
        } else {
            tie = true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(buttons[i][j].getText().isEmpty()){
                    tie = false;
                }
            }
        }

        if (gameOver) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " win!");
            tie = false;
            resetBoard();
        }

        if (tie) {
            JOptionPane.showMessageDialog(this, "TIE!");
            resetBoard();
        }
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
        playerTurnLabel.setText(playerTurn + currentPlayer);
        gameOver = false;

    }

}
